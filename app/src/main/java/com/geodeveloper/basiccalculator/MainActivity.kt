package com.geodeveloper.basiccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun performOperation(view: View){
        val btnClicked = view as Button

        val firstEditText = findViewById<EditText>(R.id.first_input)
        val secondEditText = findViewById<EditText>(R.id.second_input)

        val firstValue = firstEditText.text.toString()
        val secondValue = secondEditText.text.toString()

        if (firstValue.isNotEmpty() && secondValue.isNotEmpty()){
            //calculation
            var result = 0.0

            if (btnClicked.id == R.id.add_btn){
                result =  firstValue.toDouble() + secondValue.toDouble()
            }else if (btnClicked.id == R.id.minus_btn){
                result =  firstValue.toDouble() - secondValue.toDouble()
            }else if(btnClicked.id == R.id.mult_btn){
                result =  firstValue.toDouble() * secondValue.toDouble()
            }else if(btnClicked.id == R.id.divid_btn){
                result =  firstValue.toDouble() / secondValue.toDouble()
            }

            val firstEnteredValue =  findViewById<TextView>(R.id.first_value)
            val secondEnteredValue =  findViewById<TextView>(R.id.second_value)
            val operation = findViewById<TextView>(R.id.operation)
            val resultV =  findViewById<TextView>(R.id.result)

            firstEnteredValue.text = firstValue
            secondEnteredValue.text = secondValue
            operation.text = btnClicked.text
            resultV.text = result.toString()

            //clear
            firstEditText.text.clear()
            secondEditText.text.clear()

        }else{
            Toast.makeText(this,"Please enter your value",Toast.LENGTH_LONG).show()
        }


    }

}