package com.ines.ejerciciosconrux.components

import android.util.Log
import android.os.Handler
import android.os.Looper
import com.ines.ejerciciosconrux.services.SharedServices
import com.ines.ejerciciosconrux.services.Light

class BalanceRoutine {
    private val TAG = "BalanceRoutine"
    // Ejercicio caminar en línea recta
    fun walkStraightLine(ss: SharedServices) {
        Log.d(TAG, "Ejercicio de caminar en línea recta")
        val handler = Handler(Looper.getMainLooper())

        ss.fetchBlinkingLightMessageService()
        ss.fetchBlinkingLightMessageService()?.start()
        ss.fetchBlinkingLightMessageService()?.setEarColor(Light.BLUE)
        val mensaje = buildString {
            append("Vamos a hacer el ejercicio de caminar en línea recta. ")
            append("Imagina que hay una línea recta en el suelo y comienza a caminar sobre ella. ")
            append(" " )
            append("¡Adelante! ")
            append(" " )
            append("Mantén el equilibrio mientras caminas. ")
            append(" " )
            append("¡Muy bien! ")
            append(" " )
            append("Ahora empieza a caminar hacia atrás con cuidado. ")
            append("Despacio, mantén el equilibrio. ")
            append(" " )
            append("¡Excelente! ")
            append(" " )
            append("Has terminado el ejercicio de caminar en línea recta. ")
        }
        ss.fetchTTSService()?.speak(mensaje)
        ss.fetchExpressionService()?.changeExpression("h0292")
        ss.fetchMotorRotationMessageService()?.sendMotorRotation(
            33, 1, 6
        )
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0141")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                1, 4, 15
            )
        }, 5000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0011")
        }, 12000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0142")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                2, 4, 15
            )
        }, 15000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0020")
        }, 20000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0027")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                27, 2, 6
            )
        }, 23000)
    }
    // Equilibrio en una pierna
    fun balanceOnOneLeg(ss: SharedServices) {
        Log.d(TAG, "Ejercicio de equilibrio en una pierna")
        val handler = Handler(Looper.getMainLooper())
        val mensaje = buildString {
            append("Vamos a hacer el ejercicio de equilibrio en una pierna. ")
            append("Ponte de pie y levanta una pierna, manteniendo el equilibrio. ")
            append(" " )
            append("¡Adelante! ")
            append(" " )
            append("Mantén la posición durante unos segundos. ")
            append(" " )
            append("¡Muy bien! ")
            append(" " )
            append("Ahora cambia de pierna y repite el ejercicio. ")
            append("Mantén el equilibrio. ")
            append("Piensa en un punto fijo para ayudarte a mantenerte estable. ")
            append(" " )
            append("¡Excelente! ")
            append(" " )
            append("Has terminado el ejercicio de equilibrio en una pierna. ")
        }
        ss.fetchTTSService()?.speak(mensaje)
        ss.fetchExpressionService()?.changeExpression("h0292")
        ss.fetchMotorRotationMessageService()?.sendMotorRotation(
            33, 1, 10
        )
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0141")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                14, 10, 3
            )
        }, 5000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0011")

        }, 12000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0142")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                13, 10, 3
            )
        }, 15000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0020")
        }, 20000)

        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0027")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                27, 2, 6
            )
        }, 27000)
    }
    // Ejercicio pasos laterales
    fun sideSteps(ss: SharedServices) {
        Log.d(TAG, "Ejercicio de pasos laterales")
        val handler = Handler(Looper.getMainLooper())
        val mensaje = buildString {
            append("Vamos a hacer el ejercicio de pasos laterales. ")
            append("Ponte de pie y da un paso hacia un lado, manteniendo el equilibrio. ")
            append(" " )
            append("¡Adelante! ")
            append(" " )
            append("Mantén la espalda recta y los pies juntos. ")
            append("Ahora da un paso hacia el otro lado. ")
            append(" " )
            append("¡Muy bien! ")
            append(" " )
            append("Controla tu equilibrio mientras te mueves. ")
            append("Mejoraras tu estabilidad y coordinación. ")
            append(" " )
            append("¡Excelente! ")
            append(" " )
            append("Has terminado el ejercicio de pasos laterales. ")
        }
        ss.fetchTTSService()?.speak(mensaje)
        ss.fetchExpressionService()?.changeExpression("h0292")
        ss.fetchMotorRotationMessageService()?.sendMotorRotation(
            33, 1, 10
        )
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0151")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                5, 3, 1
            )
        }, 5000)
        handler.postDelayed({
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                5, 3, 1
            )
        }, 6000)
        handler.postDelayed({
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                5, 3, 1
            )
        }, 7000)
        handler.postDelayed({
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                5, 3, 1
            )
        }, 8000)
        handler.postDelayed({
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                5, 3, 1
            )
        }, 10000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0160")
        }, 12000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0173")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                6, 3, 1
            )
        }, 15000)
        handler.postDelayed({
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                6, 3, 1
            )
        }, 16000)
        handler.postDelayed({
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                6, 3, 1
            )
        }, 17000)
        handler.postDelayed({
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                6, 3, 1
            )
        }, 18000)
        handler.postDelayed({
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                6, 3, 1
            )
        }, 19000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0006")
        }, 20000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0027")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                27, 2, 6
            )
        }, 23000)
    }
}