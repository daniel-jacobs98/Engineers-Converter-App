package com.example.daniel.engineersuniversalconverter

import org.junit.Test

import org.junit.Assert.*


class DistanceUnitTest {
    @Test
    fun kmTo() {

        //Metres
        assertEquals(1234000.0000, DistanceConverter.distanceConvert(1234.0, "Kilometres", "Metres"))
        assertEquals(5241500.0000, DistanceConverter.distanceConvert(5214.5, "Kilometres", "Metres"))
        //Centimetres


        //Millimetres


        //Miles


        //Feet


        //Inches
    }

    fun metreTo() {

    }

    fun cmTo() {

    }

    fun mmTo() {

    }

    fun inchTo() {

    }

    fun feetTo() {

    }

    fun mileTo() {

    }
}
