package com.example.daniel.engineersuniversalconverter

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val categorySpinner  = findViewById<Spinner>(R.id.categorySelect)
        val unitSpinner1 = findViewById<Spinner>(R.id.unit1)
        val unitSpinner2 = findViewById<Spinner>(R.id.unit2)

        ArrayAdapter.createFromResource(
            this,
            R.array.conversion_categories,
            android.R.layout.simple_spinner_item
        ).also { catadapter ->
            catadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            categorySpinner.adapter = catadapter
        }

        categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val unitArray : Int = when(categorySpinner.selectedItem.toString()){
                    "Temperature" -> R.array.temperature_units
                    "Weight" -> R.array.weight_units
                    "Distance" -> R.array.distance_units
                    "Volume" -> R.array.volume_units
                    else -> R.array.number_systems
                }

                ArrayAdapter.createFromResource(
                    applicationContext,
                    unitArray,
                    android.R.layout.simple_spinner_item
                ).also{ unitAdapter ->
                    unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    unitSpinner1.adapter = unitAdapter
                    unitSpinner2.adapter = unitAdapter
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        val btnConvert = findViewById<Button>(R.id.btnConvert)
        btnConvert.setOnClickListener {
            when (categorySpinner.selectedItem.toString()) {
                "Temperature" -> clickConvertTemp(number1.text.toString(), unitSpinner1.selectedItem.toString(), unitSpinner2.selectedItem.toString())
                "Weight" -> clickConvertWeight(number1.text.toString(), unitSpinner1.selectedItem.toString(), unitSpinner2.selectedItem.toString())
                "Distance" -> clickConvertDistance(number1.text.toString(), unitSpinner1.selectedItem.toString(), unitSpinner2.selectedItem.toString())
                "Volume" -> clickConvertVolume(number1.text.toString(), unitSpinner1.selectedItem.toString(), unitSpinner2.selectedItem.toString())
                else -> clickConvertNumberSys(number1.text.toString(), unitSpinner1.selectedItem.toString(), unitSpinner2.selectedItem.toString())
            }
        }

    }

    private fun clickConvertVolume(originalString : String, convertFrom : String, convertTo : String){
        val orig = originalString.toDoubleOrNull()
        when (orig) {
            null -> Toast.makeText(applicationContext, "Cannot convert!", Toast.LENGTH_SHORT).show()
            else -> number2.setText("%.4f".format(VolumeConverter.volumeConversion(orig, convertFrom, convertTo)))
        }
    }

    private fun clickConvertTemp(originalString : String, convertFrom : String, convertTo : String){
        val orig = originalString.toDoubleOrNull()
        when (orig){
            null -> Toast.makeText(applicationContext, "Cannot convert!", Toast.LENGTH_SHORT).show()
            else -> number2.setText("%.4f".format(TemperatureConverters.tempConvert(orig, convertFrom, convertTo)))
        }
    }

    private fun clickConvertWeight(originalString: String, convertFrom: String, convertTo: String){
        val orig = originalString.toDoubleOrNull()
        if (orig != null){
            if (orig<0) {
                Toast.makeText(applicationContext, "Cannot convert a negative distance!", Toast.LENGTH_SHORT).show()
                return
            }
        }
        when (orig){
            null -> Toast.makeText(applicationContext, "Cannot Convert!", Toast.LENGTH_SHORT).show()
            else -> number2.setText("%.4f".format(WeightConverters.weightConvert(orig, convertFrom, convertTo)))
        }
    }

    private fun clickConvertDistance(originalString: String, convertFrom: String, convertTo: String){
        val orig = originalString.toDoubleOrNull()
        if (orig != null){
            if (orig<0) {
                Toast.makeText(applicationContext, "Cannot convert a negative distance!", Toast.LENGTH_SHORT).show()
                return
            }
        }
        when (orig){
            null -> Toast.makeText(applicationContext, "Cannot Convert!", Toast.LENGTH_SHORT).show()
            else -> number2.setText("%.4f".format(DistanceConverter.distanceConvert(orig, convertFrom, convertTo)))
        }
    }

    private fun clickConvertNumberSys(originalString: String, convertFrom: String, convertTo: String){
        var sanitisedString = NumberSysConverters.sanitiseSysString(originalString)
        var valid: Boolean = when (convertFrom){
            "Decimal" -> NumberSysConverters.validDec(sanitisedString)
            "Hexadecimal" -> NumberSysConverters.validHex(sanitisedString)
            "Octal" -> NumberSysConverters.validOct(sanitisedString)
            "Unsigned Binary" -> NumberSysConverters.validUBin(sanitisedString)
            else -> false
        }
        if(valid) {
            number2.setText(NumberSysConverters.numberSysConvert(sanitisedString, convertFrom, convertTo))
        }else{
            Toast.makeText(applicationContext, "Cannot convert", Toast.LENGTH_SHORT).show()
        }
    }


}


