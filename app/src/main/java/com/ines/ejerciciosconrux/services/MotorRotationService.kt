package com.ines.ejerciciosconrux.services

import android.util.Log
import com.leitianpai.robotsdk.RobotService
import com.leitianpai.robotsdk.message.ActionMessage

class MotorRotationService(private val robotService: RobotService) {
    // Método para enviar la acción de rotación del motor
    fun sendMotorRotation(action: Int, speed: Int, step: Int) {
        if (robotService != null) {
            val actionMessage = ActionMessage()
            actionMessage[action, speed] = step
            robotService.robotActionCommand(actionMessage)
        } else {
            Log.e("MotorRotationService", "robotService is null")
        }
    }
}