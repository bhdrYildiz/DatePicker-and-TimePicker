package com.yildiz.dateandtimepicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    var year = 0
    var month = 0
    var day = 0
    var hour = 0
    var minute = 0

    var savedYear = 0
    var savedMonth = 0
    var savedDay = 0
    var savedHour = 0
    var savedMinute = 0

    private fun getCalendar(){
        var calendar = Calendar.getInstance()
        year = calendar.get(Calendar.YEAR)
        month = calendar.get(Calendar.MONTH)
        day = calendar.get(Calendar.DAY_OF_MONTH)
        hour = calendar.get(Calendar.HOUR)
        minute = calendar.get(Calendar.MINUTE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_chooseDate.setOnClickListener {
            getCalendar()
            DatePickerDialog(this,this,year,month,day).show()

        }

        btn_chooseTime.setOnClickListener {
            getCalendar()
            TimePickerDialog(this,this,hour,minute,true).show()
        }

    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, day: Int) {
        savedYear = year
        savedMonth = month
        savedDay = day

        getCalendar()
        tv_date.text = "Tarih : $day-$month-$year"
    }

    override fun onTimeSet(view: TimePicker?, hour: Int, minute: Int) {
        savedHour = hour
        savedMinute = minute

        getCalendar()
        tv_time.text = "Saat : $hour : $minute"

    }

}