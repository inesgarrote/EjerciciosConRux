package com.ines.ejerciciosconrux.components

import android.util.Log
import android.os.Handler
import android.os.Looper
import com.ines.ejerciciosconrux.services.SharedServices
import com.ines.ejerciciosconrux.services.Light

// Clase que representa la rutina de movilidad articular
class MobilityRoutine {
    private val TAG = "MobilityRoutine"
    // Ejercicio: Rotación de cuello
    fun neckTiltExercise(ss: SharedServices) {
        Log.d(TAG, "Ejercicio de inclinación de cuello")
        val handler = Handler(Looper.getMainLooper())
        // Encendemos la luces
        ss.fetchBlinkingLightMessageService()
        ss.fetchBlinkingLightMessageService()?.start()
        ss.fetchBlinkingLightMessageService()?.setEarColor(Light.WHITE)


        val mensaje = buildString {
            append("Vamos a comenzar con la rotación de cuello. ")
            append("Manten la espalda recta y el mentón ligeramente hacia el pecho.")
            append("Gira la cabeza lentamente hacia un lado como si quisieras mirar por encima de tu hombro.")
            append(" ")
            append("¡Vas Genial!")
            append(" ")
            append("Ahora, vuelve al centro y repite el movimiento hacia el otro lado.")
            append("Este ejercicio nos ayudará a mejorar la movilidad y flexibilidad de nuestro cuello.")
            append("¡Sigue así y verás cómo tu cuello se siente más relajado y flexible!")
            append("Hazlo suavemente, sin forzar el movimiento.")
            append("Recuerda mantener los hombros relajados, para evitar tensión.")
            append(" ")
            append("¡Muy bien!")
            append(" ")
            append("Mantén la posición un momento y respira profundamente.")
            append(" ")
            append("¡Venga!")
            append(" ")
            append("¡Falta poco, mantén el ritmo!")
            // final
            append(" ")
            append("¡Genial trabajo! ")
            append(" ")
            append("Has completado la rotación de cuello.")
        }
        ss.fetchTTSService()?.speak(mensaje)
        ss.fetchExpressionService()?.changeExpression("h0292")
        ss.fetchMotorRotationMessageService()?.sendMotorRotation(
            33, 1, 6
        )
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0025")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
               25, 1, 5
           )
        }, 6000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0024")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                26, 1, 5
            )
        }, 15000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0020")
        }, 20000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0025")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                25, 1, 5
            )
        }, 25000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0024")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                26, 1, 5
            )
        }, 30000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0108")
        }, 38000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0025")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                25, 1, 3
            )
        }, 40000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0024")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                26, 1, 3
            )
        }, 45000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0027")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                27, 2, 6
            )
        }, 49000)
    }
    // Ejercicio: Rotación de muñeca
    fun wristRotationExercise(ss: SharedServices) {
        Log.d(TAG, "Ejercicio de rotación de muñeca")
        val handler = Handler(Looper.getMainLooper())
        val mensaje = buildString {
            append("Vamos a comenzar con la rotación de muñecas. ")
            append("Extiende tus brazos hacia adelante con las palmas mirando hacia abajo.")
            append("Ahora, empieza a girar ambas muñecas hacia dentro, suavemente y sin forzar.")
            append(" ")
            append("¡Fenomenal!")
            append(" ")
            append("Ahora, cambia la dirección y gira las muñecas hacia fuera.")
            append("Este ejercicio nos ayudará a mejorar la movilidad y flexibilidad de nuestras manos.")
            append(" ")
            append("¡Tú puedes!")
            append(" ")
            append("¡Mantén el ritmo y respira profundamente. ")
            append("Este ejercicio es ideal para relajar las muñecas.")
            // final
            append(" ")
            append("¡Estupendo trabajo!")
            append(" ")
            append("Has completado la rotación de muñecas. ")
        }
        ss.fetchTTSService()?.speak(mensaje)
        ss.fetchExpressionService()?.changeExpression("h0292") // feliz
        ss.fetchMotorRotationMessageService()?.sendMotorRotation(
            33, 1, 6
        )
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0015")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                18, 1, 3
            )
        }, 15000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0108")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                18, 1, 3
            )
        }, 20000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0020")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                18, 1, 3
            )
        }, 25000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0015")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                18, 1, 3
            )
        }, 29000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0027") // final
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                27, 2, 6
            )
        }, 33000)
    }
    fun armRotationExercise(ss: SharedServices) {
        Log.d(TAG, "Ejercicio de rotación de brazos")
        val handler = Handler(Looper.getMainLooper())
        val mensaje = buildString {
            append("Vamos a comenzar con la rotación de brazos. ")
            append("Extiende tus brazos hacia los lados a la altura de los hombros.")
            append("Ahora, empieza a hacer círculos con ambos brazos hacia adelante, manteniendo los codos rectos.")
            append(" ")
            append("¡Increíble!")
            append(" ")
            append("Ahora, cambia la dirección y haz círculos hacia atrás.")
            append("Este ejercicio nos ayudará a mejorar la movilidad y flexibilidad de nuestros hombros.")
            append(" ")
            append("¡Continúa!")
            append(" ")
            append("Mantén el ritmo y respira profundamente. ")
            append(" ")
            append("¿No te sientes genial?")
            append(" ")
            append("Este ejercicio es ideal para relajar los hombros y brazos.")
            // final
            append(" ")
            append("¡Impresionante trabajo!")
            append(" ")
            append("Has completado la rotación de brazos. ")
        }
        ss.fetchTTSService()?.speak(mensaje)

        ss.fetchExpressionService()?.changeExpression("h0292")
        ss.fetchMotorRotationMessageService()?.sendMotorRotation(
            33, 1, 6
        )
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0020")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                85, 3, 1
            )
        }, 15000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0011")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                86, 3, 1
            )
        }, 20000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0108")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                85, 3, 1
            )
        }, 24000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0011")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                86, 3, 1
            )
        }, 29000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0020") // mirar hacia abajo
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                85, 3, 1
            )
        }, 33000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0011")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                86, 3, 1
            )
        }, 36000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0027")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                27, 2, 6
            )
        }, 40000)
    }
    // Ejercicio: Giro de cintura
    fun waistTwistExercise(ss: SharedServices) {
        Log.d(TAG, "Ejercicio de giro de cintura")
        val handler = Handler(Looper.getMainLooper())
        val mensaje = buildString {
            append("Vamos a comenzar con el giro de cintura.")
            append("Ponte de pie con los pies al ancho de los hombros y las manos en las caderas.")
            append("Ahora, gira suavemente la parte superior del cuerpo hacia un lado.")
            append(" ")
            append("¡Eso es!")
            append(" ")
            append("Mantén la parte inferior del cuerpo estable mientras giras.")
            append("No pares, ya veras cómo te sientes mejor y más ágil.")
            append(" ")
            append("¡Venga!")
            append(" ")
            append("Mantén el ritmo y respira profundamente.")
            append(" ")
            append("¡Excelente!")
            append(" ")
            append("Ahora, vuelve al centro y repite el movimiento hacia el otro lado.")
            append("Este ejercicio nos ayudará a mejorar la movilidad y flexibilidad de nuestra cintura.")
            append("Disfruta del movimiento y siente cómo tu cuerpo se estira y se relaja.")
            append(" ")
            append("¡Mantén el ritmo!")
            append(" ")
            append("Lo estás haciendo genial. ")
            append("Recuerda mantener la espalda recta y los abdominales contraídos.")
            append(" ")
            append("¡Impresionante!")
            append(" ")
            append("Que bien mueves la cintura.")
            append(" ")
            append("¡Falta poco!")
            append(" ")
            append("¡Tu puedes!")
            append(" ")
            append("Este ejercicio es ideal para relajar la zona lumbar y mejorar la postura.")
            // final
            append(" ")
            append("¡Maravillosa ejecución! ")
            append(" ")
            append("Has completado el giro de cintura. ")
        }
        ss.fetchTTSService()?.speak(mensaje)
        ss.fetchExpressionService()?.changeExpression("h0292")
        ss.fetchMotorRotationMessageService()?.sendMotorRotation(
            33, 1, 6
        )
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0024")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                27, 2, 10
            )
        }, 10000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0011")
        }, 15000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0025")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                27, 2, 10
            )
        }, 20000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0099")
        }, 25000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0108")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                27, 2, 8
            )
        }, 30000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0020")
        }, 35000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0108")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                27, 2, 8
            )
        }, 40000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0011")
        }, 45000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0099")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                27, 2, 10
            )
        }, 50000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0020")
        }, 58000)
        handler.postDelayed({ // final
            ss.fetchExpressionService()?.changeExpression("h0027")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                27, 2, 6
            )
        }, 64000)
    }
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
}


