package com.example.async

import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//Pass Views to handle
class AsyncTaskRunner: ViewModel() {

    private val dataToShow = MutableLiveData<String>()

    fun getData(): LiveData<String>{
        return dataToShow
    }

    // Sync method
    fun runAnAsyncTask(iterations: Int) {
        viewModelScope.launch {
            println("start load")
            doTask(iterations)
            println("end load")
        }
    }

    // Async method
    private suspend fun doTask(iterations: Int) {
        return withContext(Dispatchers.IO){
            var current  = 0
            repeat(iterations) {
                current += 2
                delay(100)
                dataToShow.postValue(current.toString())
            }
        }
    }
}