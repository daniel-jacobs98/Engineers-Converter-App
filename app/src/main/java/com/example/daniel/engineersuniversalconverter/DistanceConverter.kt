package com.example.daniel.engineersuniversalconverter

class DistanceConverter{
    companion object {
        fun distanceConvert(original : Double, convertFrom : String, convertTo : String) : Double{
            var convertedDistance : Double = original
            when (convertFrom){
                "Kilometres" -> {
                    convertedDistance = when (convertTo){
                        "Metres" -> original*1000
                        "Centimetres" -> (original*1000)*100
                        "Millimetres" -> ((original*1000)*100)*10
                        "Inches" -> (original * 39370.079)
                        "Feet" -> (original * 3280.84)
                        "Miles" -> (original / 1.609)
                        else -> original
                    }
                }
                "Metres" -> {
                    convertedDistance = when (convertTo){
                        "Kilometres" -> (original/1000)
                        "Centimetres" -> (original*100)
                        "Millimetres" -> (original*100)*10
                        "Inches" -> (original * 39.37)
                        "Feet" -> (original * 3.281)
                        "Miles" -> (original / 1609.344)
                        else -> original
                    }
                }
                "Centimetres" -> {
                    convertedDistance = when (convertTo){
                        "Kilometres" -> (original/100)/1000
                        "Metres" -> (original/100)
                        "Millimetres" -> (original * 10)
                        "Inches" -> (original/2.54)
                        "Feet" -> (original/30.48)
                        "Miles" -> (original/160934.4)
                        else -> original
                    }
                }
                "Millimetres" -> {
                    convertedDistance = when (convertTo){
                        "Kilometres" -> ((original/10)/100)/1000
                        "Metres" -> (original/10)/100
                        "Centimetres" -> (original/10)
                        "Inches" -> (original/25.4)
                        "Feet" -> (original/304.8)
                        "Miles" -> ((original/10)/100)/1609.344
                        else -> original
                    }
                }
                "Inches" -> {
                    convertedDistance= when (convertTo){
                        "Kilometres" -> (original/39370.079)
                        "Metres" -> (original/39.37)
                        "Millimetres" -> (original*25.4)
                        "Centimetres" -> (original*2.54)
                        "Feet" -> (original/12)
                        "Miles" -> (original/63360)
                        else -> original
                    }
                }
                "Feet" -> {
                    convertedDistance = when (convertTo){
                        "Kilometres" -> (original/3280.84)
                        "Metres" -> (original/3.281)
                        "Millimetres" -> (original*304.8)
                        "Inches" -> (original/12)
                        "Centimetres" -> (original*30.48)
                        "Miles" -> (original/5280)
                        else -> original
                    }
                }
                "Miles" -> {
                    convertedDistance = when (convertTo){
                        "Kilometres" -> (original*1.609344)
                        "Metres" -> (original*1609.344)
                        "Millimetres" -> (original*1609.344)*1000
                        "Inches" -> (original*63360)
                        "Feet" -> (original*5280)
                        "Centimetres" -> (original*1609.344)*100
                        else -> original
                    }
                }
            }
            return convertedDistance
        }
    }
}