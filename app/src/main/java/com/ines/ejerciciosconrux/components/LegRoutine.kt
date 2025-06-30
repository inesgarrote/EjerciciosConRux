package com.ines.ejerciciosconrux.components

import android.util.Log
import android.os.Handler
import android.os.Looper
import com.ines.ejerciciosconrux.services.SharedServices
import com.ines.ejerciciosconrux.services.Light

class LegRoutine {
    private val TAG = "LegRoutine"
    // Ejercicio levantamiento de rodillas
    fun kneeRaise(ss: SharedServices) {
        Log.d(TAG, "Ejercicio de levantamiento de rodillas")
        val handler = Handler(Looper.getMainLooper())

        ss.fetchBlinkingLightMessageService()
        ss.fetchBlinkingLightMessageService()?.start()
        ss.fetchBlinkingLightMessageService()?.setEarColor(Light.ORANGE)
        val mensaje = buildString {
            append("Vamos a comenzar con el ejercicio de levantamiento de rodillas. ")
            append("Siéntate en una silla con la espalda recta y los pies apoyados en el suelo. ")
            append("Levanta una rodilla despacio, como si quisieras acercarla al pecho. ")
            append("Mantenla un segundo en el aire y luego bájala con cuidado. ")
            append(" ")
            append("¡Muy bien! ")
            append(" ")
            append("Ahora cambia de pierna y repite el movimiento. ")
            append(" ")
            append("¡Eso es! ")
            append(" ")
            append("Este ejercicio ayuda a fortalecer las piernas y mejora la movilidad. ")
            append(" ")
            append("¡Estás haciéndolo genial! ")
            append(" ")
            append("Recuerda mantener la espalda recta y el abdomen contraído. ")
            append("Respira profundo y mantén un ritmo constante. ")
            append(" ")
            append("¡Fenomenal! ")
            append(" ")
            append("Has terminado el ejercicio de levantamiento de rodillas. ")
        }
        ss.fetchTTSService()?.speak(mensaje)
        ss.fetchExpressionService()?.changeExpression("h0292")
        ss.fetchMotorRotationMessageService()?.sendMotorRotation(
            33, 1, 6
        )
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0015")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                13, 5, 1
            )
        }, 6000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0006")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                13, 5, 1
            )
        }, 10000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0003")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                13, 5, 1
            )
        }, 14000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0024")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                13, 5, 1
            )
        }, 18000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0025")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                14, 5, 1
            )
        }, 22000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0007")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                14, 5, 1
            )
        }, 26000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0099")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                14, 5, 1
            )
        }, 30000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0020")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                14, 5, 1
            )
        }, 34000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0027")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                27, 2, 6
            )
        }, 40000)
    }
    fun squat(ss: SharedServices) {
        Log.d(TAG, "Ejercicio de sentadillas asistidas")
        val handler = Handler(Looper.getMainLooper())
        val mensaje = buildString {
            append("Vamos con las sentadillas asistidas. ")
            append("Colócate de pie, detrás de una silla y sujeta el respaldo para mantener el equilibrio. ")
            append("Ahora, flexiona lentamente las rodillas, bajando un poco, como si fueras a sentarte. ")
            append(" ")
            append("¡Muy bien! ")
            append(" ")
            append("No bajes demasiado, solo hasta donde te sientas cómodo. ")
            append(" ")
            append("¡Increíble! ")
            append(" ")
            append("Vuelve a subir despacio. ")
            append(" ")
            append("¡Falta poco! ")
            append(" ")
            append("Siente cómo se activan los músculos de tus piernas. ")
            append(" ")
            append("¡Excelente trabajo! ")
            append(" ")
            append("Has completado las sentadillas asistidas. ")
        }
        ss.fetchTTSService()?.speak(mensaje)
        ss.fetchExpressionService()?.changeExpression("h0292")
        ss.fetchMotorRotationMessageService()?.sendMotorRotation(
            33, 1, 6
        )
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0020")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                74, 1 ,1
            )
        }, 5000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0003")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                75, 1, 1          )
        }, 10000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0030")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                74, 1, 1
            )
        }, 15000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0099")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                75, 1, 1
            )
        }, 20000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0077")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                74, 1, 1
            )
        }, 25000)

        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0027")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                27, 2, 6
            )
        }, 30000)
    }
    fun calfRaise(ss: SharedServices) {
        Log.d(TAG, "Ejercicio de levantamiento de talones")
        val handler = Handler(Looper.getMainLooper())
        val mensaje = buildString {
            append("Ahora vamos con la elevación de talones. ")
            append("Ponte de pie detrás de una silla resistente y sujeta el respaldo con ambas manos. ")
            append("Con la espalda recta, sube lentamente los talones, apoyándote en la punta de los pies. ")
            append(" ")
            append("¡Muy bien! ")
            append(" ")
            append("Mantén la posición un segundo y baja con suavidad. ")
            append("Repite este movimiento varias veces con calma. ")
            append("Este ejercicio mejora tu equilibrio y fortalece los tobillos. ")
            append(" ")
            append("¡Mágnifico! ")
            append(" ")
            append("Has completado la elevación de talones. ")
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
        }, 5000)

        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0077")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                58, 1, 1
            )
        }, 10000)

        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0025")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                58, 1, 1
            )
        }, 15000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0099")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                58, 1, 1
            )
        }, 20000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0020")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                58, 1, 2
            )
        }, 25000)

        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0027")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                27, 2, 6
            )
        }, 32000)
    }
}