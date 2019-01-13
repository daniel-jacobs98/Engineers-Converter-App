package com.example.daniel.engineersuniversalconverter

import android.app.Activity
import android.app.Application
import android.widget.Toast
import kotlin.ranges.*

class NumberSysConverters{
    companion object {
        fun numberSysConvert(original : String, convertFrom: String, convertTo: String) : String{
            var convertedString : String = original
            when (convertFrom){
                "Unsigned Binary" -> {
                    convertedString = when (convertTo){
                        "Decimal" -> uBinToDec(original).toString()
                        "Hexadecimal" -> decToHex(uBinToDec(original))
                        "Octal" -> decToOct(uBinToDec(original))
                        else -> original
                    }
                }

                "Decimal" -> {
                    convertedString = when (convertTo){
                        "Unsigned Binary" -> decToUBin(original.toInt())
                        "Hexadecimal" -> decToHex(original.toInt())
                        "Octal" -> decToOct(original.toInt())
                        else -> original
                    }
                }

                "Hexadecimal" -> {
                    convertedString = when (convertTo) {
                        "Unsigned Binary" -> decToUBin(hexToDec(original))
                        "Decimal" -> hexToDec(original).toString()
                        "Octal" -> decToOct(hexToDec(original))
                        else -> original
                    }
                }

                "Octal" -> {
                    convertedString = when (convertTo){
                        "Unsigned Binary" -> decToUBin(octToDec(original))
                        "Decimal" -> octToDec(original).toString()
                        "Hexadecimal" -> decToHex(octToDec(original))
                        else -> original
                    }
                }
            }
            return convertedString
        }

        private fun uBinToDec(binary: String) : Int{
            var dec = 0
            var powerCounter = (binary.length - 1)
            for(curr: Char in binary){
                if(curr == '1') {
                    dec += intPow(2, powerCounter)
                }
                powerCounter--
            }
            return dec
        }

        private fun hexToDec(hex: String) : Int{
            var sum = 0
            var powerCounter = (hex.length-1)
            for(curr: Char in hex){
                val currentVal: Int = when(curr){
                    'F' -> 15
                    'E' -> 14
                    'D' -> 13
                    'C' -> 12
                    'B' -> 11
                    'A' -> 10
                    else -> curr.toString().toInt()
                }
                sum+= currentVal * intPow(16, powerCounter)
                powerCounter--
            }
            return sum
        }

        private fun octToDec(oct: String) : Int{
            var sum = 0
            var powerCounter = (oct.length-1)
            for(curr: Char in oct){
                val currentVal = curr.toString().toInt()
                sum+= currentVal * intPow(8, powerCounter)
                powerCounter-=1
            }
            return sum
        }

        private fun decToUBin(dec: Int) : String{
            var binStrRev: String = ""
            var rem:Int = 0
            var num = dec
            do{
                rem = num % 2
                binStrRev+=rem
                num = (num/2)
            }while(num>0)
            return binStrRev.reversed()
        }

        private fun decToHex(dec: Int) : String{
            var rem: Int = 0
            val sb = StringBuilder()
            var num = dec
            do{
                rem = num%16
                when(rem){
                    10 -> sb.append("A")
                    11 -> sb.append("B")
                    12 -> sb.append("C")
                    13 -> sb.append("D")
                    14 -> sb.append("E")
                    15 -> sb.append("F")
                    else -> sb.append(rem)
                }
                num = num/16
            }while(num>0)
            return sb.reverse().toString()
        }

        private fun decToOct(dec: Int) : String{
            var sb = StringBuilder()
            var rem: Int = 0
            var num = dec
            do{
                rem = num%8
                sb.append(rem)
                num = num/8
            }while(num>0)
            return sb.reverse().toString()
        }

        fun validUBin(binary: String): Boolean{
            for(curr: Char in binary){
                if(curr != '1' && curr != '0'){
                    return false
                }
            }
            return true
        }

        fun validHex(hex: String): Boolean{
            var startIndex = 0
            if(hex.length==0) return false
            if(hex[0]=='0' && hex[1]=='x'){
                startIndex = 2
            }
            for(i in startIndex..hex.length){
                if(!(hex[i] in 'A'..'F') && !(hex[i] in 'a'..'f') && !(hex[i] in '0'..'9')){
                    return false
                }
            }
            return true
        }

        fun validOct(oct: String): Boolean{
            var startIndex = 0
            if(oct.length == 0) return false
            if(oct[0]=='0' && oct[1]=='x'){
                startIndex = 2
            }
            for(i in startIndex..oct.length){
                if(!(oct[i] in '0'..'7')){
                    return false
                }
            }
            return true
        }

        fun validDec(dec: String): Boolean{
            for(i in 0..dec.length-1){
                if(!(dec[i] in '0'..'9')){
                    return false
                }
            }
            return true
        }

        fun sanitiseSysString(sysString: String): String{
            if(sysString[0]=='0' && sysString[1]=='x') {
                return sysString.substring(2).toUpperCase()
            }else{
                return sysString.toUpperCase()
            }
        }

        private fun intPow(val1: Int, val2: Int): Int{
            var sum: Int =1
            for(i in 1..val2){
                sum*= val1
            }
            return sum
        }

    }
}