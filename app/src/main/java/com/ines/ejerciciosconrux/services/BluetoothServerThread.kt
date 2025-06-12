package com.ines.ejerciciosconrux.services

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothServerSocket
import android.bluetooth.BluetoothSocket
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.io.IOException
import java.util.UUID

class BluetoothServerThread(
    private val context: Context,
    private val adapter: BluetoothAdapter,
    private val uuid: UUID,
    private val onCommand: (String) -> Unit
) : Thread() {

    companion object {
        private const val TAG = "BTServer"
    }

    private var serverSocket: BluetoothServerSocket? = null

    init {
        Log.d(TAG, "init(): comprobando permisos y abriendo serverSocket…")
        val hasPermission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            ContextCompat.checkSelfPermission(
                context, Manifest.permission.BLUETOOTH_CONNECT
            ) == PackageManager.PERMISSION_GRANTED
        } else {
            ContextCompat.checkSelfPermission(
                context, Manifest.permission.BLUETOOTH_ADMIN
            ) == PackageManager.PERMISSION_GRANTED
        }

        if (!hasPermission) {
            Log.e(TAG, "init(): permiso Bluetooth no concedido")
            serverSocket = null
        } else {
            serverSocket = try {
                adapter.listenUsingRfcommWithServiceRecord("RuxService", uuid)
                    .also { Log.d(TAG, "init(): serverSocket abierto en UUID=$uuid") }
            } catch (e: IOException) {
                Log.e(TAG, "init(): error al abrir serverSocket", e)
                null
            }
        }
    }

    override fun run() {
        val sock = serverSocket ?: run {
            Log.e(TAG, "run(): serverSocket es null, saliendo del hilo")
            return
        }
        Log.d(TAG, "run(): llamando accept(), esperando cliente…")
        try {
            val socket = sock.accept()
            Log.d(TAG, "run(): cliente conectado: ${socket.remoteDevice.address}")
            // avisamos al usuario
            (context as AppCompatActivity).runOnUiThread {
                Toast.makeText(context, "¡Móvil conectado!", Toast.LENGTH_SHORT).show()
            }
            sock.close()
            manageConnection(socket)
        } catch (e: IOException) {
            Log.e(TAG, "run(): error en accept()", e)
        }
    }

    private fun manageConnection(socket: BluetoothSocket) {
        Log.d(TAG, "manageConnection(): iniciando lectura de InputStream…")
        val input = socket.inputStream
        val buf = ByteArray(256)
        while (true) {
            try {
                val bytes = input.read(buf)
                if (bytes > 0) {
                    val cmd = String(buf, 0, bytes, Charsets.UTF_8).trim()
                    Log.d(TAG, "manageConnection(): recibido comando: $cmd")
                    onCommand(cmd)
                }
            } catch (e: IOException) {
                Log.e(TAG, "manageConnection(): conexión interrumpida", e)
                break
            }
        }
        socket.close()
    }

    fun cancel() {
        Log.d(TAG, "cancel(): cerrando serverSocket")
        try {
            serverSocket?.close()
        } catch (e: IOException) {
            Log.e(TAG, "cancel(): error al cerrar serverSocket", e)
        }
    }
}