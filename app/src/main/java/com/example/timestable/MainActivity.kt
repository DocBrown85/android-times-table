package com.example.timestable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {

    lateinit var timesTableListView: ListView

    fun generateTimesTable(timesTableNumber: Int) {

        var timesTableContent = ArrayList<String>()
        for (x in 1 until 100) {
            val timesTableItem = x * timesTableNumber
            timesTableContent.add(timesTableItem.toString())
        }

        val arrayAdapter = ArrayAdapter<String>(applicationContext, android.R.layout.simple_list_item_1, timesTableContent)

        timesTableListView.adapter = arrayAdapter

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timesTableListView = findViewById<ListView>(R.id.timesTableListView)
        val timesTableSeekBar = findViewById<SeekBar>(R.id.timesTableSeekBar)

        val max = 20
        val startingPosition = 10

        timesTableSeekBar.max = max
        timesTableSeekBar.progress = startingPosition

        generateTimesTable(startingPosition)

        timesTableSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                val min = 1

                val timesTableNumber = if (i < min) {
                    timesTableSeekBar.progress = min
                    min
                }
                else {
                    i
                }

                Log.i("SeekBar Value", timesTableNumber.toString())

                generateTimesTable(timesTableNumber)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }

        })
    }
}