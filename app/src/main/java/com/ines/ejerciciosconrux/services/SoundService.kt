package com.ines.ejerciciosconrux.services

import com.leitianpai.robotsdk.RobotService

class SoundService(private val robotService: RobotService) {
    fun playSound(soundId: String) {
        robotService.robotControlSound(soundId)
    }
}