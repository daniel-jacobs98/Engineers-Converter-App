package com.example.daniel.engineersuniversalconverter

class TemperatureConverters{
    companion object {
        fun tempConvert(original : Double, convertFrom : String, convertTo : String): Double{
            var convertedTemp : Double = original
            when (convertFrom){
                "Celsius" -> {
                    when (convertTo){
                        "Kelvin" -> {
                            convertedTemp = celsiusToKelvin(original)
                        }

                        "Fahrenheit" -> {
                            convertedTemp = celsiusToFahr(original)
                        }
                    }
                }

                "Kelvin" -> {
                    when (convertTo){
                        "Celsius" -> {
                            convertedTemp = kelvinToCelsius(original)
                        }

                        "Fahrenheit" -> {
                            convertedTemp = celsiusToFahr(kelvinToCelsius(original))
                        }
                    }
                }

                "Fahrenheit" -> {
                    when (convertTo) {
                        "Celsius" -> {
                            convertedTemp = fahrenheitToCelsius(original)
                        }

                        "Kelvin" -> {
                            convertedTemp = celsiusToKelvin(fahrenheitToCelsius(original))
                        }
                    }
                }
            }
            return convertedTemp
        }

        private fun kelvinToCelsius(kelvin : Double) : Double{
            return kelvin - 273.15
        }

        private fun fahrenheitToCelsius(fahr : Double) : Double{
            var five : Double = 5.0
            return ((fahr - 32) * five.div(9.0))
        }

        private fun celsiusToKelvin(cels : Double) : Double{
            return cels + 273.15
        }

        private fun celsiusToFahr(cels : Double) : Double{
            val nine : Double = 9.0
            return ((cels * (nine.div(5.0))) + 32)
        }

    }
}