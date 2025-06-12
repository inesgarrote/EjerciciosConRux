package com.ines.ejerciciosconrux.services

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.leitianpai.robotsdk.RobotService
import com.leitianpai.robotsdk.message.AntennaLightMessage
import java.util.Random


class BlinkingLightMessageService(private val robotService: RobotService) {
    private var isFixedInterval = false
    private var fromInterval = 0
    private var toInterval = 0
    private var fixedInterval = 0
    private var blinkHandler: Handler? = null
    private var blinkRunnable: Runnable? = null
    private var isOff = false
    protected var currentEarsColor: Int = 0

    init {
        setIsFixedInterval(500)
            .setEarColor(Light.YELLOW)
    }

    fun setCurrentEarsColor(currentEarsColor: Int): BlinkingLightMessageService {
        this.currentEarsColor = currentEarsColor
        return this
    }

    fun setEarColor(myColor: Int): BlinkingLightMessageService {
        var color: Int = Light.getLight(myColor)
        while (color == Light.BLACK || color == currentEarsColor) {
            color = Light.getLight(myColor)
        }
        currentEarsColor = color
        return this
        Log.d("BlinkingLightMessageService", "Ear color set to $color")
    }

    fun setIsFixedInterval(fixedInterval: Int): BlinkingLightMessageService {
        this.fixedInterval = fixedInterval
        isFixedInterval = true
        return this
    }

    protected fun lightMessage(lightValue: Int) {
        val antennaLightMessage = AntennaLightMessage()
        antennaLightMessage.set(lightValue)
        robotService.robotAntennaLight(antennaLightMessage)
    }

    private val newInterval: Int
        get() = if (isFixedInterval) fixedInterval else random.nextInt(toInterval - fromInterval) + fromInterval

    fun start() {
        Log.d("BlinkingLightMessageService", "BlinkingLightMessageService started")
        stop()
        blinkHandler = Handler(Looper.getMainLooper())
        blinkRunnable = object : Runnable {
            override fun run() {
                lightMessage(if (isOff) currentEarsColor else OFF)
                isOff = !isOff
                blinkHandler!!.postDelayed(this, this@BlinkingLightMessageService.newInterval.toLong())
            }
        }
        // Evita el error si blinkRunnable es null
        blinkRunnable?.let {
            blinkHandler!!.postDelayed(it, newInterval.toLong())
        }
    }

    fun stop() {
        if (blinkHandler != null) {
            blinkHandler!!.removeCallbacks(blinkRunnable!!)
            blinkHandler = null
            blinkRunnable = null
        }
        isOff = true
        lightMessage(OFF)
    }

    companion object {
        private val OFF: Int = Light.BLACK
        private val random = Random()
    }
}