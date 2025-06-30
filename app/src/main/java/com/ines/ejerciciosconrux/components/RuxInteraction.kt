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
        ss.fetchExpressionService()?.changeExpression("h0292")
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
        ss.fetchExpressionService()?.startExpression("h0292")
        val mensaje = buildString {
            append("Bienvenido a la rutina de Fortalecimiento de Piernas. ")
            append("Hoy haremos tres ejercicios que te ayudarán a ganar fuerza y estabilidad: ")
            append("primero, Levantamiento de rodillas para activar muslos y caderas; ")
            append("después, Sentadillas para trabajar glúteos y cuádriceps; ")
            append("y por último, Elevación de talones para fortalecer tus tobillos y pantorrillas. ")
            append("Cuando estés listo, pulsa el botón ‘¡Vamos allá!’ y empezamos.")
        }

        ss.fetchTTSService()?.speak(mensaje)

    }

    fun ejerciciosBrazosExplanation(ss: SharedServices) {
        Log.d(TAG, "Intro Ejercicios para Brazos")
        ss.fetchExpressionService()?.startExpression("h0292")
       val mensaje = buildString {
           append("Bienvenido a la rutina de ejercicios para brazos. ")
           append("Hoy realizaremos tres movimientos sencillos pero muy efectivos. ")
           append("Primero, comenzaremos con flexiones en la pared para fortalecer tus brazos y pecho. ")
           append("Luego, haremos elevaciones laterales de brazos para trabajar hombros y mejorar la movilidad. ")
           append("Y para terminar, practicaremos la presión de palmas, un ejercicio ideal para activar músculos del antebrazo y mejorar la coordinación. ")
           append("Cuando estés preparado, pulsa el botón ‘¡Vamos allá!’ y comenzamos.")
        }
        ss.fetchTTSService()?.speak(mensaje)
    }

    fun equilibrioEstabilidadExplanation(ss: SharedServices) {
        Log.d(TAG, "Intro Equilibrio y Estabilidad")
        ss.fetchExpressionService()?.startExpression("h0292")
        val mensaje = buildString {
            append("Bienvenido a la rutina de Equilibrio y Estabilidad. ")
            append("Hoy realizaremos tres ejercicios que te ayudarán a mejorar tu coordinación y prevenir caídas. ")
            append("Comenzaremos caminando en línea recta, un ejercicio sencillo que entrena tu estabilidad al avanzar paso a paso. ")
            append("Después, haremos equilibrio sobre una pierna, lo que fortalecerá los músculos de tus piernas y tobillos. ")
            append("Y para terminar, practicaremos pasos laterales, que mejoran tu agilidad y control del cuerpo. ")
            append("Cuando estés listo, pulsa el botón ‘¡Vamos allá!’ y comenzamos.")
        }
        ss.fetchTTSService()?.speak(mensaje)
    }

    fun relajacionEstiramientoExplanation(ss: SharedServices) {
        Log.d(TAG, "Intro Relajación y Estiramiento")
        ss.fetchExpressionService()?.startExpression("h0292")
        val mensaje = buildString {
            append("Bienvenido a la rutina de Relajación y Estiramiento. ")
            append("Hoy realizaremos tres ejercicios suaves para ayudar a tu cuerpo a relajarse y mejorar la flexibilidad. ")
            append("Empezaremos con un estiramiento de brazos, ideal para liberar la tensión acumulada. ")
            append("Luego, haremos una inclinación de torso hacia los lados, para relajar la espalda y los costados. ")
            append("Y finalmente, estiraremos las piernas, un ejercicio muy útil después de moverse o estar sentado mucho tiempo. ")
            append("Cuando estés listo, pulsa el botón ‘¡Vamos allá!’ y comenzamos.")
        }
        ss.fetchTTSService()?.speak(mensaje)
    }

    fun ejercicioCompletoExplanation(ss: SharedServices) {
        Log.d(TAG, "Intro Ejercicio Completo")
        ss.fetchExpressionService()?.startExpression("h0292")
        val mensaje = buildString {
            append("Bienvenido a la rutina de Ejercicio Completo. ")
            append("Hoy realizaremos una serie de ejercicios que combinan movilidad, fuerza, equilibrio y estiramiento. ")
            append("Comenzaremos con marcha en el sitio, para activar todo el cuerpo y elevar la energía. ")
            append("Después, haremos sentadillas asistidas, un excelente ejercicio para fortalecer piernas y glúteos. ")
            append("Seguiremos con flexiones en la pared, que ayudan a trabajar brazos y pecho. ")
            append("A continuación, practicaremos equilibrio en una pierna, para mejorar la estabilidad y la concentración. ")
            append("Y por último, realizaremos una suave inclinación de torso, ideal para estirar la espalda y relajar el cuerpo. ")
            append("Cuando estés preparado, pulsa el botón ‘¡Vamos allá!’ y comenzamos juntos.")
        }
        ss.fetchTTSService()?.speak(mensaje)
    }
}