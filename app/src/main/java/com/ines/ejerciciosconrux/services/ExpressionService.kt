package com.ines.ejerciciosconrux.services

import com.leitianpai.robotsdk.RobotService

class ExpressionService(private val robotService: RobotService) {
    fun startExpression(expressionId: String) {
        robotService.robotStartExpression(expressionId)
    }
    fun changeExpression(expressionId: String) {
        robotService.robotChangeExpression(expressionId)
    }
    fun stopExpression() {
        robotService.robotStopExpression()
    }
}
