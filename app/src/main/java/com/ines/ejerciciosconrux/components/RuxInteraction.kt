package com.ines.ejerciciosconrux.components

import android.os.Handler
import android.os.Looper
import com.ines.ejerciciosconrux.services.SharedServices
import android.util.Log

class RuxInteraction {
    private val TAG = "RuxInteraction"
    private val handler = Handler(Looper.getMainLooper())
    // Interacción durante la pantalla de selección
    fun selectionScreenExplanation(ss: SharedServices) {
        ss.fetchTTSService()?.speak(
            "Bienvenido a la pantalla de selección. " +
                    "Aquí podrás elegir entre diferentes rutinas de ejercicios. "
        )
        ss.fetchExpressionService()?.changeExpression("h0020")
        ss.fetchMotorRotationMessageService()?.sendMotorRotation(
            27, 2, 10
        )
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0077")
            ss.fetchTTSService()?.speak(" Puedes elegir entre movilidad articular, fortalecimiento de piernas, ejercicios para brazos, equilibrio y estabilidad, relajación y estiramiento o un ejercicio completo." +
                    " ¿Qué te apetece hacer hoy?"
            )
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                28, 2, 8
            )
        }, 4000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0108")
        }, 8000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0020")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                11, 1, 5
            )
        }, 12000)
        handler.postDelayed({
            ss.fetchExpressionService()?.changeExpression("h0108")
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                12, 1, 5
            )
        }, 14000)
        handler.postDelayed({
            ss.fetchMotorRotationMessageService()?.sendMotorRotation(
                13, 1, 5
            )
        }, 16000)

    }

    fun movilidadArticularExplanation(ss: SharedServices) {
        Log.d(TAG, "Intro Movilidad Articular")
        // 1) Expresión inicial
      //  ss.fetchExpressionService()?.stopExpression()
        ss.fetchExpressionService()?.changeExpression("h0292")
        // 2) Texto de introducción
        val mensaje = buildString {
            append("Bienvenido a la rutina de Movilidad Articular. ")
            append("Hoy haremos cinco ejercicios para despertar y flexibilizar tu cuerpo: ")
            append("primero, Rotación de cuello para aliviar tensión; ")
            append("luego, Rotación de muñeca para preparar tus manos; ")
            append("a continuación, Rotación de brazos para calentar los hombros; ")
            append("seguido de Giro de cintura para mejorar la movilidad de tu tronco; ")
            append("y, por último, Marcha en el sitio para activar todo el cuerpo. ")
            append("Cuando estés listo, pulsa el botón ‘¡Vamos allá!’ y comenzamos.")
        }
        ss.fetchTTSService()?.speak(mensaje)
    }

    fun fortalecimientoPiernasExplanation(ss: SharedServices) {
        Log.d(TAG, "Intro Fortalecimiento de Piernas")
        ss.fetchExpressionService()?.startExpression("h0010") // ejemplo: cara enérgica
        ss.fetchBlinkingLightMessageService()?.start()
        ss.fetchTTSService()?.speak(
            "Ahora pasamos a la rutina de Fortalecimiento de Piernas. " +
                    "Prepárate para tonificar tus músculos."
        )
    }

    fun ejerciciosBrazosExplanation(ss: SharedServices) {
        Log.d(TAG, "Intro Ejercicios para Brazos")
        ss.fetchExpressionService()?.startExpression("h0015") // ejemplo: cara concentrada
        ss.fetchBlinkingLightMessageService()?.start()
        ss.fetchTTSService()?.speak(
            "Comenzamos con Ejercicios para Brazos. " +
                    "Vamos a trabajar la fuerza y movilidad de tus brazos."
        )
    }

    fun equilibrioEstabilidadExplanation(ss: SharedServices) {
        Log.d(TAG, "Intro Equilibrio y Estabilidad")
        ss.fetchExpressionService()?.startExpression("h0022") // ejemplo: cara calmada
        ss.fetchBlinkingLightMessageService()?.start()
        ss.fetchTTSService()?.speak(
            "Continuamos con Equilibrio y Estabilidad. " +
                    "Estos ejercicios mejorarán tu coordinación y postura."
        )
    }

    fun relajacionEstiramientoExplanation(ss: SharedServices) {
        Log.d(TAG, "Intro Relajación y Estiramiento")
        ss.fetchExpressionService()?.startExpression("h0025") // ejemplo: cara relajada
        ss.fetchBlinkingLightMessageService()?.start()
        ss.fetchTTSService()?.speak(
            "Ahora toca Relajación y Estiramiento. " +
                    "Tómate tu tiempo para estirar y desconectar."
        )
    }

    fun ejercicioCompletoExplanation(ss: SharedServices) {
        Log.d(TAG, "Intro Ejercicio Completo")
        ss.fetchExpressionService()?.startExpression("h0018") // ejemplo: cara motivada
        ss.fetchBlinkingLightMessageService()?.start()
        ss.fetchTTSService()?.speak(
            "Vamos con la rutina de Ejercicio Completo. " +
                    "Combinaremos movilidad, fuerza y estiramientos en un solo programa."
        )
    }

    fun stopAll(ss: SharedServices) {
        Log.d(TAG, "Stopping all interactions")
        handler.removeCallbacksAndMessages(null)
        handler.postAtFrontOfQueue {
            ss.fetchTTSService()?.speak("Ejercicio terminado")
        }
    }
}