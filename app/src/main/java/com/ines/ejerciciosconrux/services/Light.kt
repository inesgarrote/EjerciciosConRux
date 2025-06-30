package com.ines.ejerciciosconrux.services




import com.leitianpai.robotsdk.commandlib.Light
import kotlin.random.Random

class Light: Light() {
    companion object {
        const val RED = com.leitianpai.robotsdk.commandlib.Light.RED
        const val GREEN = com.leitianpai.robotsdk.commandlib.Light.GREEN
        const val BLUE = com.leitianpai.robotsdk.commandlib.Light.BLUE
        const val ORANGE = com.leitianpai.robotsdk.commandlib.Light.ORANGE
        const val WHITE = com.leitianpai.robotsdk.commandlib.Light.WHITE
        const val YELLOW = com.leitianpai.robotsdk.commandlib.Light.YELLOW
        const val CYAN = com.leitianpai.robotsdk.commandlib.Light.CYAN
        const val BLACK = com.leitianpai.robotsdk.commandlib.Light.BLACK
        const val PURPLE = com.leitianpai.robotsdk.commandlib.Light.PURPLE

        fun getLight(color: Int): Int {
            return color
        }
    }
}
