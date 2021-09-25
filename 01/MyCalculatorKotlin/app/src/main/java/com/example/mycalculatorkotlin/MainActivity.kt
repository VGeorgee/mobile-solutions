package com.example.mycalculatorkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var calculator: Calculator
    private lateinit var resultTextField: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextField = findViewById<TextView>(R.id.resultTextView)
        calculator = Calculator()
    }

    fun onClickHandlerForNumbers(view: View){
        ensureNoLeadingZeros()
        val button = view as Button
        appendToText(button.text as String)
    }

    fun onClickHandlerForOperators(view: View){
        val button = view as Button
        setText(calculateResult())
        appendToText(button.text as String)
    }

    fun onClickHandlerForEquals(view: View){
        setText(calculateResult())
    }

    fun onClickHandlerForClear(view: View){
        setText("0")
    }

    private fun calculateResult(): String{
        val originalText = resultTextField.text as String

        val lastIndexOfText = originalText.length - 1
        if(isOperator(originalText[lastIndexOfText])){ // delete last character if operator -> no double op error
            return originalText.substring(0, lastIndexOfText)
        }

        return calculator.calculate(originalText)
    }

    private fun setText(text: String){
        resultTextField.text = text
    }

    private fun appendToText(text: String){
        resultTextField.text = resultTextField.text as String + text
    }

    private fun ensureNoLeadingZeros(){
        val originalValue = resultTextField.text as String
        resultTextField.text =
            if(originalValue == "0") ""
            else originalValue
    }

    private fun isOperator(character: Char): Boolean{
        return "+-*/".contains(character)
    }
}