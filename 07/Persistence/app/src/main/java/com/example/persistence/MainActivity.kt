package com.example.persistence

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var text: EditText
    lateinit var textView: TextView

    lateinit var sharedPreference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        text = findViewById(R.id.editTextTextPersonName)
        textView = findViewById(R.id.textView)

        sharedPreference = getSharedPreferences(getString(R.string.preference), Context.MODE_PRIVATE)


        if(savedInstanceState != null){
            textView.text = savedInstanceState.getString(TEXT_VIEW_KEY)
        }

        val result = sharedPreference.getString(TEXT_VIEW_KEY, null)
        if(result != null){
            textView.text = result
        }

    }

    fun buttonHandler(view: View){
        textView.text = text.text.toString()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TEXT_VIEW_KEY, textView.text.toString())
    }

    override fun onPause() {
        super.onPause()
        with (sharedPreference.edit()) {
            putString(TEXT_VIEW_KEY, textView.text.toString())
            apply()
        }
    }



    companion object {
        private const val TEXT_VIEW_KEY = "TEXT_VIEW_KEY"
    }
}