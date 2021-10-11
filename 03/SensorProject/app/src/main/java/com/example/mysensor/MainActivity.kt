package com.example.mysensor

import android.hardware.Sensor
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var sensorEventListener: SensorListener
    lateinit var accelero: Sensor

    lateinit var sensorManagerInstance: SensorManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManagerInstance = getSystemService(SENSOR_SERVICE) as SensorManager
        accelero = sensorManagerInstance.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        sensorEventListener = SensorListener(findViewById(R.id.myTextView))

        sensorManagerInstance.registerListener(sensorEventListener, accelero, SensorManager.SENSOR_DELAY_NORMAL);
    }


    override fun onResume() {
        super.onResume()
        sensorManagerInstance.registerListener(sensorEventListener, accelero, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManagerInstance.unregisterListener(sensorEventListener)
    }
}