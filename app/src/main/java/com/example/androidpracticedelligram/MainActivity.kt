package com.example.androidpracticedelligram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidpracticedelligram.ui_textview.TextViewActivity
import com.example.androidpracticedelligram.ui_checkbox.CheckboxActivity
import com.example.androidpracticedelligram.ui_webview.WebviewActivity
import com.example.androidpracticedelligram.ui_datepicker.PickerActivity
import com.example.androidpracticedelligram.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.btn1.setOnClickListener {
            val intent = Intent(this, TextViewActivity::class.java)
            startActivity(intent)

        }
        binding.btn2.setOnClickListener {
            val intent = Intent(this, CheckboxActivity::class.java)
            startActivity(intent)
        }
        binding.btn3.setOnClickListener {
            val intent = Intent(this, WebviewActivity ::class.java)
            startActivity(intent)
        }
        binding.datePickerBtn.setOnClickListener {
            val intent = Intent(this, PickerActivity ::class.java)
            startActivity(intent)
        }

        
    }



}