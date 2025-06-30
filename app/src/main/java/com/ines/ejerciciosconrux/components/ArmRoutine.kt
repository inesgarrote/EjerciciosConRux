package com.ines.ejerciciosconrux.components

import android.util.Log
import android.os.Handler
import android.os.Looper
import com.ines.ejerciciosconrux.services.SharedServices
import com.ines.ejerciciosconrux.services.Light

class ArmRoutine {
    private val TAG = "ArmRoutine"
    // ejercicio flexion pared
    fun wallPushUp(ss: SharedServices) {
        Log.d(TAG, "Ejercicio de flexión en pared")
        val handler = Handler(Looper.getMainLooper())

        ss.fetchBlinkingLightMessageService()
        ss.fetchBlinkingLightMessageService()?.start()
        ss.fetchBlinkingLightMessageService()?.setEarColor(Light.GREEN)
        val mensaje = buildString {
            append("Vamos a hacer el ejercicio de flexión en pared. ")
            append("Colócate de pie frente a una pared y apoya las manos a la altura de los hombros. ")
            append("Flexiona los codos lentamente, acercando el pecho hacia la pared. ")
            append(" ")
            append("¡Adelante! ")
            append(" ")
            append("Mantén el cuerpo recto. ")
            append(" ")
            append("¡Muy bien! ")
            append(" ")
            append("Empuja con los brazos y vuelve a la posición inicial. ")
            append(" ")
            append("¡Excelente! ")
            append(" ")
            append("Has terminado la flexión en pared. ")
        }
        ss.fetchTTSService()?.speak(mensaje)
        ss.fetchExpressionService()?.changeExpression("h0292")
        ss.fetchMotorRotationMessageService()?.sendMotorRotation(
            33, 1, 6
        )
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0077")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                11, 5, 1
            )
        }, 5000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0015")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                12, 5, 1
            )
        }, 10000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0099")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                13, 5, 1
            )
        }, 15000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0020")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                14, 5, 1
            )
        }, 20000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0027")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                27, 2, 6
            )
        }, 25000)
    }
    // elevacion lateral de brazos
    fun lateralArmRaise(ss: SharedServices) {
        Log.d(TAG, "Ejercicio de elevación lateral de brazos")
        val handler = Handler(Looper.getMainLooper())
        val mensaje = buildString {
            append("Ahora vamos con la elevación lateral de brazos. ")
            append("Ponte de pie, con los pies separados al ancho de los hombros. ")
            append("Ahora, levanta ambos brazos hacia los lados hasta que estén alineados con los hombros. ")
            append(" ")
            append("¡Muy bien! ")
            append(" ")
            append("Mantén la posición un segundo… y baja con suavidad. ")
            append("Este ejercicio fortalece los hombros y mejora la movilidad. ")
            append(" ")
            append("¡Genial trabajo! ")
            append(" ")
            append("Repite el movimiento manteniendo un ritmo suave y constante. ")
            append("Respira hondo mientras subes, y suelta el aire al bajar. ")
            append(" ")
            append("¡Fantástico! ")
            append(" ")
            append("Has completado la elevación lateral de brazos. ")
        }
        ss.fetchTTSService()?.speak(mensaje)
        ss.fetchExpressionService()?.changeExpression("h0292")
        ss.fetchMotorRotationMessageService()?.sendMotorRotation(
            33, 1, 6
        )
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0007")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                62, 1, 1
            )
        }, 5000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0024")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                62, 1, 1
            )
        }, 10000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0025")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                62, 1, 1
            )
        }, 15000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0046")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                62, 1, 1
            )
        }, 20000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0099")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                62, 1, 1
            )
        }, 25000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h00141")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                62, 1, 1
            )
        }, 30000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0027")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                27, 2, 6
            )
        }, 33000)
    }
    fun palmPress(ss: SharedServices) {
        Log.d(TAG, "Ejercicio de presión de palmas")
        val handler = Handler(Looper.getMainLooper())
        val mensaje = buildString {
            append("Ahora vamos con la presión de palmas. ")
            append("Coloca las palmas de tus manos frente a tu pecho, como si estuvieras rezando. ")
            append("Presiona las palmas una contra otra con firmeza. ")
            append(" ")
            append("¡Muy bien! ")
            append(" ")
            append("¡Lo estas haciendo genial! ")
            append(" ")
            append("Mantén la presión durante unos segundos y suelta lentamente. ")
            append("Este ejercicio fortalece los músculos de los brazos y mejora la coordinación. ")
            append(" ")
            append("¡Excelente trabajo! ")
            append(" ")
            append("Has completado la presión de palmas. ")
        }
        ss.fetchTTSService()?.speak(mensaje)
        ss.fetchExpressionService()?.changeExpression("h0292")
        ss.fetchMotorRotationMessageService()?.sendMotorRotation(
            33, 1, 6
        )
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0001")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                60, 1, 3
            )
        }, 5000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0003")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                23, 1, 1
            )
        }, 10000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0018")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                60, 1, 3
            )
        }, 15000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0099")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                23, 1, 1
            )
        }, 20000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0108")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                60, 1, 3
            )
        }, 25000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0027")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                27, 2, 6
            )
        }, 30000)

    }
}