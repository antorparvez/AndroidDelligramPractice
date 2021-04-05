package com.example.androidpracticedelligram.activity_04_picker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import com.example.androidpracticedelligram.BaseActivity
import com.example.androidpracticedelligram.R
import com.example.androidpracticedelligram.databinding.ActivityMainBinding
import com.example.androidpracticedelligram.databinding.ActivityPickerBinding
import java.util.*

class PickerActivity : BaseActivity(), DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {
    private lateinit var binding: ActivityPickerBinding
    var day = 0
    var month: Int = 0
    var year: Int = 0
    var hour: Int = 0
    var minute: Int = 0
    var myDay = 0
    var myMonth: Int = 0
    var myYear: Int = 0
    var myHour: Int = 0
    var myMinute: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPickerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        initToolbar("Date and Time Picker")
        getDatePickerDate()

        binding.btnTime.setOnClickListener {
            timePickerDialog()
        }

        val calendar: Calendar = Calendar.getInstance()
        day = calendar.get(Calendar.DAY_OF_MONTH)
        month = calendar.get(Calendar.MONTH)
        year = calendar.get(Calendar.YEAR)
        hour = calendar.get(Calendar.HOUR)
        minute = calendar.get(Calendar.MINUTE)

        binding.inDate.text = "$month-$day-$year\n$hour$minute"

    }

    private fun timePickerDialog() {

       val datePickerDialog =
            DatePickerDialog(this, this@PickerActivity, year, month,day)
        datePickerDialog.show()


    }

    private fun getDatePickerDate() {
        val today = Calendar.getInstance()
        binding.datePicker.init(
            today[Calendar.YEAR],
            today[Calendar.MONTH],
            today[Calendar.DAY_OF_MONTH]


        )

        { view, year, month, day ->
            val month = month + 1
            val msg = "You Selected: $day/$month/$year"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        myDay = day
        myYear = year
        myMonth = month
        val calendar: Calendar = Calendar.getInstance()
        hour = calendar.get(Calendar.HOUR)
        minute = calendar.get(Calendar.MINUTE)
        val timePickerDialog = TimePickerDialog(this, this@PickerActivity, hour, minute,
            DateFormat.is24HourFormat(this))
        timePickerDialog.show()

    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {

        myHour = hourOfDay
        myMinute = minute

        binding.inDate.text = "$month-$day-$year\n$hour$minute"
    }


}