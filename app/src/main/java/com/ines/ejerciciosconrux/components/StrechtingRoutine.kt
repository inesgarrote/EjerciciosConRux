package com.ines.ejerciciosconrux.components

import android.util.Log
import android.os.Handler
import android.os.Looper
import com.ines.ejerciciosconrux.services.SharedServices
import com.ines.ejerciciosconrux.services.Light

class StrechtingRoutine {
    private val TAG = "StrechtingRoutine"
    // Ejercicio estiramiento de brazos
    fun armStretchExercise(ss: SharedServices) {
        Log.d(TAG, "Ejercicio de estiramiento de brazos")
        val handler = Handler(Looper.getMainLooper())

        ss.fetchBlinkingLightMessageService()
        ss.fetchBlinkingLightMessageService()?.start()
        ss.fetchBlinkingLightMessageService()?.setEarColor(Light.RED)
        val mensaje = buildString {
            append("Vamos a hacer un estiramiento de brazos. ")
            append("Eleva ambos brazos sobre la cabeza y entrelaza las manos mientras los estiras hacia arriba. ")
            append(" ")
            append("Este ejercicio hará que te sientas genial. ")
            append(" ")
            append("Cuando quieras, suelta lentamente y baja los brazos con calma. ")
            append(" ")
            append("¡Estupendo! ")
            append(" ")
            append("Has completado el estiramiento de brazos sobre la cabeza. ")
        }
        ss.fetchTTSService()?.speak(mensaje)
        ss.fetchExpressionService()?.changeExpression("h0292")
        ss.fetchMotorRotationMessageService()?.sendMotorRotation(
            33, 1, 6
        )
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0020")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                13, 7, 1
            )
        }, 3000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0026")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                14, 7, 1
            )
        }, 5000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0030")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                80, 6, 2
            )
        }, 7000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0007")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                13, 7, 1
            )
        }, 10000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0003")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                14, 7, 1
            )
        }, 11000)

        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0027")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                27, 2, 6
            )
        }, 13000)
    }
    // Ejercicio inclinación de torso
    fun torsoBendExercise(ss: SharedServices) {
        Log.d(TAG, "Ejercicio de inclinación de torso")
        val handler = Handler(Looper.getMainLooper())

        val mensaje = buildString {
            append("Ahora vamos a hacer una inclinación de torso. ")
            append("Coloca la mano izquierda sobre tu cabeza e inclina el torso hacia el lado derecho. ")
            append(" ")
            append("Ahora, hazlo hacia el lado izquierdo. ")
            append(" ")
            append("¡Muy bien!")
            append(" ")
            append("Siente el estiramiento. ")
            append(" ")
            append("¡Fantástico!")
            append(" ")
            append("Has completado el ejercicio de inclinación de torso.")
        }
        ss.fetchTTSService()?.speak(mensaje)
        ss.fetchExpressionService()?.changeExpression("h0292")
        ss.fetchMotorRotationMessageService()?.sendMotorRotation(
            33, 1, 6
        )
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0025")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                14, 7, 1
            )
        }, 4000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0024")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                13, 7, 1
            )
        }, 9000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0027")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                27, 2, 6
            )
        }, 13000)
    }
    // Ejercicio estiramiento de piernas
    fun legStretchExercise(ss: SharedServices) {
        Log.d(TAG, "Ejercicio de estiramiento de piernas")
        val handler = Handler(Looper.getMainLooper())
        val mensaje = buildString {
            append("Ahora vamos a hacer un estiramiento de piernas. ")
            append("Ponte de pie con los pies juntos. ")
            append("Lentamente, inclina el tronco hacia adelante, dejando caer los brazos hacia el suelo. ")
            append(" ")
            append("¡Estupendo! ")
            append(" ")
            append("Has completado el estiramiento de piernas.")
        }
        ss.fetchTTSService()?.speak(mensaje)
        ss.fetchExpressionService()?.changeExpression("h0292")
        ss.fetchMotorRotationMessageService()?.sendMotorRotation(
            33, 1, 6
        )
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0024")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                58, 1, 1
            )
        }, 4000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0020")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                58, 1, 1
            )
        }, 6000)

        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0077")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                58, 1, 1
            )
        }, 9000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0027")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                27, 2, 6
            )
        }, 13000)
    }
}