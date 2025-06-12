package com.ines.ejerciciosconrux.services

import com.leitianpai.robotsdk.RobotService

class TTSService(private val robotService: RobotService) {
    fun speak(text: String) {
        robotService.robotPlayTTs(text)
    }
}