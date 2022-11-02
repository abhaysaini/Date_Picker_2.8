package com.example.assignment28

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.Month
import java.util.*

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {

    private val calender = Calendar.getInstance()
    private val formatter = SimpleDateFormat("MM , dd, yyyy", Locale.US)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_d: Button = findViewById(R.id.button)

        button_d.setOnClickListener {
            DatePickerDialog(
                this,
                this,
                calender.get(Calendar.YEAR),
                calender.get(Calendar.MONTH),
                calender.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayofMonth: Int) {
        calender.set(year, month, dayofMonth)
        callfun(calender.timeInMillis)
    }

    private fun callfun(timestamp: Long) {
        findViewById<TextView>(R.id.date_text).text = formatter.format(timestamp)
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}