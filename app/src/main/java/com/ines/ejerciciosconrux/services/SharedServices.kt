package com.ines.ejerciciosconrux.services

import android.content.Context
import android.util.Log
import com.leitianpai.robotsdk.RobotService


class SharedServices {
    var robotService: RobotService? = null
        private set

    var openedServices: Boolean = false
        private set


    private var blinkingLightMessageService: BlinkingLightMessageService? = null
    var motorRotationMessageService: MotorRotationService? = null
        private set
    var soundService: SoundService? = null
        private set
    private var ttsService: TTSService? = null

    var expressionService: ExpressionService? = null
         private set

    fun fetchRobotService(): RobotService? {
        return robotService
    }

    fun fetchBlinkingLightMessageService(): BlinkingLightMessageService? {
        return blinkingLightMessageService
    }

    fun fetchMotorRotationMessageService(): MotorRotationService? {
        return motorRotationMessageService
    }

    fun fetchSoundService(): SoundService? {
        return soundService
    }

    fun fetchTTSService(): TTSService? {
        return ttsService
    }

    fun fetchExpressionService(): ExpressionService? {
        return expressionService
    }

    fun closeServices() {
        Log.d(TAG, "Closing services")
        if(blinkingLightMessageService != null) {
            blinkingLightMessageService?.stop()
        }
        robotService?.apply {
            robotCloseMotor()
            robotCloseAntennaLight()
            robotCloseSensor()
            unbindService()
        }
        openedServices = false
    }

    fun startServices() {
        if (robotService == null) {
            Log.e(TAG, "RobotService is null, cannot start services")
            return
        }
        robotService?.apply {
            try {
                robotCloseMotor()
                robotCloseAntennaLight()
                robotOpenMotor()
                openedServices = true
            } catch (e: Exception) {
                Log.e(TAG, "Error starting services: ${e::class.java.simpleName} - ${e.message}", e)
            }
        }
    }

    fun isOpenedServices(): Boolean {
        return openedServices
    }

    companion object {
        private const val TAG = "SharedServices"
        @Volatile
        private var instance: SharedServices? = null

        fun getInstance(context: Context?): SharedServices {
            return instance ?: synchronized(this) {
                instance ?: SharedServices().also {
                    Log.d(TAG, "Initializing SharedServices")
                    try {
                        it.robotService = RobotService.getInstance(context)
                        it.blinkingLightMessageService = BlinkingLightMessageService(it.robotService!!)
                        it.motorRotationMessageService = MotorRotationService(it.robotService!!)
                        it.soundService = SoundService(it.robotService!!)
                        it.ttsService = TTSService(it.robotService!!)
                        it.expressionService = ExpressionService(it.robotService!!)
                        instance = it
                    } catch (e: Exception) {
                        Log.e(TAG, "Error getting instance of shared services: ${e.message}", e)
                    }
                }
            }
        }
    }
}
