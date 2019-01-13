package com.example.daniel.engineersuniversalconverter

class WeightConverters{
    companion object {
        fun weightConvert(original : Double, convertFrom : String, convertTo : String) : Double{
            var convertedWeight : Double = original
            when (convertFrom){
                "Kilograms" -> {
                    convertedWeight = when (convertTo) {
                        "Grams" -> (original * 1000)
                        "Tonnes" -> (original / 1000)
                        "Pounds" -> (original * 2.205)
                        else -> original
                    }
                }

                "Grams" -> {
                    convertedWeight = when (convertTo) {
                        "Kilograms" -> (original / 1000)
                        "Tonnes" -> ((original / 1000)/1000)
                        "Pounds" -> (original / 453.592)
                        else -> original
                    }
                }

                "Tonnes" -> {
                    convertedWeight = when (convertTo) {
                        "Kilograms" -> (original * 1000)
                        "Grams" -> ((original * 1000) *1000)
                        "Pounds" -> (original * 2204.623)
                        else -> original
                    }
                }

                "Pounds" -> {
                    convertedWeight = when (convertTo) {
                        "Kilograms" -> (original / 2.205)
                        "Grams" -> (original * 453.592)
                        "Tonnes" -> (original / 2204.623)
                        else -> original
                    }
                }
            }
            return convertedWeight
        }
    }
}