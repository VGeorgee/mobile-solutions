package com.example.async

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(){

    lateinit var textView: TextView
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        progressBar = findViewById(R.id.progressBar)
    }

    fun buttonHandler(view: View){

        val runner = AsyncTaskRunner()

        runner.getData().observe(this, Observer {
            textView.text = it
        })

        runner.runAnAsyncTask(50)
    }

}