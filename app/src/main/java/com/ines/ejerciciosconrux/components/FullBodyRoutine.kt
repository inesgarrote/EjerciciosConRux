package com.ines.ejerciciosconrux.components

import android.util.Log
import android.os.Handler
import android.os.Looper
import com.ines.ejerciciosconrux.services.SharedServices
import com.ines.ejerciciosconrux.services.Light

class FullBodyRoutine {
    private val TAG = "FullBodyRoutine"
    // Ejercicio: Marcha en el sitio
    fun marchInPlaceExercise(ss: SharedServices) {
        Log.d(TAG, "Ejercicio de marcha en el sitio")
        val handler = Handler(Looper.getMainLooper())
        val mensaje = buildString {
            append("Vamos a comenzar con la marcha en el sitio. ")
            append("Ponte de pie con los pies al ancho de los hombros y los brazos a los lados.")
            append("Ahora, empieza a marchar levantando las rodillas y moviendo los brazos.")
            append(" ")
            append("¡Eso es!")
            append(" ")
            append("Mantén un ritmo constante y respira profundamente.")
            append("Este ejercicio nos ayudará a activar todo el cuerpo y mejorar la circulación.")
            append(" ")
            append("¡Sigue así!")
            append(" ")
            append("Mantén el ritmo y disfruta del movimiento.")
            append(" ")
            append("¡Falta poco!")
            append(" ")
            append("Ya veras como tu cuerpo se siente más activo.")
            // final
            append(" ")
            append("¡Fantástico trabajo!")
            append(" ")
            append("Has completado la marcha en el sitio. ")
        }
        ss.fetchTTSService()?.speak(mensaje)
        ss.fetchExpressionService()?.changeExpression("h0292") // feliz
        ss.fetchMotorRotationMessageService()?.sendMotorRotation(
            33, 1, 6
        )
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0108")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                19, 2, 10
            )
        }, 5000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0020")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                19, 2, 5
            )
        }, 20000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0099")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                19, 2, 10
            )
        }, 25000)
        handler.postDelayed({ // final
            ss.fetchExpressionService()?.changeExpression("h0027")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                27, 2, 6
            )
        }, 30000)
    }
    // Ejercicio: Sentadillas asistidas
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
    // Ejercicio: Flexiones de brazos
    fun wallPushUp(ss: SharedServices) {
        Log.d(TAG, "Ejercicio de flexión en pared")
        val handler = Handler(Looper.getMainLooper())
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
}