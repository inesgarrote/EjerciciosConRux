package com.ines.ejerciciosconrux

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager as SysBluetoothManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.ines.ejerciciosconrux.components.RuxInteraction
import com.ines.ejerciciosconrux.components.mobilityroutine.MobilityRoutine
import com.ines.ejerciciosconrux.services.BluetoothServerThread
import com.ines.ejerciciosconrux.services.SharedServices
import java.util.UUID

class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity"
        // UUID SPP estándar
        private val APP_UUID: UUID =
            UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")
    }

    private lateinit var sharedServices: SharedServices
    private var serverThread: BluetoothServerThread? = null

    // Handler para esperar a que SharedServices esté listo
    private val serviceLoadedHandler = Handler(Looper.getMainLooper())
    private val handler = Handler(Looper.getMainLooper())
    private val serviceLoadedRunner = object : Runnable {
        override fun run() {
            if (sharedServices.fetchRobotService() != null) {
                serviceLoadedHandler.removeCallbacks(this)
                sharedServices.startServices()
                Log.d(TAG, "✅ RobotService conectado. Iniciando servicios...")
                sharedServices.fetchTTSService()
                    ?.speak("Hola, soy Rux y seré tu entrenador personal. ¿Listo para empezar?")
                sharedServices.fetchExpressionService()?.stopExpression()
                sharedServices.fetchExpressionService()?.startExpression("h0020")  // feliz
                sharedServices.fetchMotorRotationMessageService()?.sendMotorRotation(
                    33, 1, 6
                )
                handler.postDelayed({
                    sharedServices.fetchExpressionService()?.changeExpression("h0027")  // corazones
                    sharedServices.fetchMotorRotationMessageService()?.sendMotorRotation(
                        19, 1, 6
                    )
                }, 4000)
                handler.postDelayed({
                    sharedServices.fetchExpressionService()?.changeExpression("h0108")  // standby
                }, 7000)
               // Inicia el servidor Bluetooth
                startBluetoothServer()
            } else {
                Log.d(TAG, "⏳ RobotService no está listo. Reintentando...")
                serviceLoadedHandler.postDelayed(this, 1000)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 1) Inicializa SharedServices
        sharedServices = SharedServices.getInstance(this)
        serviceLoadedHandler.post(serviceLoadedRunner)
    }

    /** Arranca el servidor Bluetooth RFCOMM */
    private fun startBluetoothServer() {
        val discoverableIntent = Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE).apply {
            putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300)  // 300s = 5 minutos
        }
        Log.d(TAG, "startBluetoothServer(): iniciando...")
        // 1) BluetoothAdapter a través del servicio del sistema
        val sysBtManager = getSystemService(Context.BLUETOOTH_SERVICE) as SysBluetoothManager
        val btAdapter: BluetoothAdapter? = sysBtManager.adapter

        if (btAdapter == null) {
            Log.e(TAG, "Bluetooth no soportado")
            runOnUiThread {
                Toast.makeText(this, "Bluetooth no soportado", Toast.LENGTH_LONG).show()
            }
            return
        }
        if (!btAdapter.isEnabled) {
            Log.e(TAG, "Bluetooth desactivado")
            runOnUiThread {
                Toast.makeText(this, "Activa Bluetooth en el robot", Toast.LENGTH_LONG).show()
            }
            return
        }
        // 2) Comprueba permisos
        val hasPerm = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            ContextCompat.checkSelfPermission(
                this, Manifest.permission.BLUETOOTH_CONNECT
            ) == android.content.pm.PackageManager.PERMISSION_GRANTED
        } else {
            ContextCompat.checkSelfPermission(
                this, Manifest.permission.BLUETOOTH_ADMIN
            ) == android.content.pm.PackageManager.PERMISSION_GRANTED
        }
        if (!hasPerm) {
            Log.e(TAG, "Sin permiso BLUETOOTH_CONNECT/BLUETOOTH_ADMIN")
            runOnUiThread {
                Toast.makeText(this, "Permiso Bluetooth no concedido", Toast.LENGTH_LONG).show()
            }
            return
        }

        // 3) Lanza el hilo servidor
        serverThread = BluetoothServerThread(
            this,
            btAdapter,
            APP_UUID
        ) { cmd ->
            // feedback de comando recibido
            runOnUiThread {
          //      Toast.makeText(this, "Comando recibido: $cmd", Toast.LENGTH_SHORT).show()
            }
            handleCommand(cmd)
        }.also { it.start() }

        Log.d(TAG, "✅ BluetoothServerThread iniciado, esperando conexión…")
        runOnUiThread {
            Toast.makeText(this, "Servidor Bluetooth iniciado", Toast.LENGTH_SHORT).show()
        }
    }

    /** Despacha cada comando a la rutina correspondiente */
    private fun handleCommand(cmd: String) {
        Log.d(TAG, "handleCommand: $cmd")
        when (cmd) {
            // Pantalla selección
            "SELECTION" -> RuxInteraction().selectionScreenExplanation(sharedServices)
            // Detalles de cada rutina
            "MOVILIDAD_DETAIL"  -> RuxInteraction().movilidadArticularExplanation(sharedServices)
            "PIERNAS_DETAIL" -> RuxInteraction().fortalecimientoPiernasExplanation(sharedServices)
            "BRAZOS_DETAIL" -> RuxInteraction().ejerciciosBrazosExplanation(sharedServices)
            "EQUILIBRIO_DETAIL" -> RuxInteraction().equilibrioEstabilidadExplanation(sharedServices)
            "RELAX_DETAIL" -> RuxInteraction().relajacionEstiramientoExplanation(sharedServices)
            "COMPLETO_DETAIL" -> RuxInteraction().ejercicioCompletoExplanation(sharedServices)
            // Rutina Movilidad Articular
            "ROTACION_CUELLO" -> MobilityRoutine().neckTiltExercise(sharedServices)
            "ROTACION_MUNECA" -> MobilityRoutine().wristRotationExercise(sharedServices)
            "ROTACION_BRAZOS" -> MobilityRoutine().armRotationExercise(sharedServices)
            "GIRO_CINTURA" -> MobilityRoutine().waistTwistExercise(sharedServices)
            "MARCHA" -> MobilityRoutine().marchInPlaceExercise(sharedServices)
            // Para el ejercicio si el usuario lo solicita
            "PARAR_EJECUCION" -> RuxInteraction().stopAll(sharedServices)
            // Rutina Fortalecimiento de Piernas
            // "BRAZOS"     -> ArmsRoutine().startRoutine(sharedServices)
            // "EQUILIBRIO" -> BalanceRoutine().startRoutine(sharedServices)
            // "RELAX"      -> RelaxRoutine().startRoutine(sharedServices)
            // "COMPLETO"   -> FullBodyRoutine().startRoutine(sharedServices)
            else -> Log.w(TAG, "Comando desconocido: $cmd")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Para el servidor Bluetooth y cierra servicios
        serverThread?.cancel()
        sharedServices.closeServices()
    }
}
