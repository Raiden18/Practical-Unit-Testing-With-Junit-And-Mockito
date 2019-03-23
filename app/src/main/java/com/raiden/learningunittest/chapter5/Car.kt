package com.raiden.learningunittest.chapter5

interface Car {
    val needsFuel: Boolean;
    val engineTemperature: Double;
    fun driveTo(destination: String)
}