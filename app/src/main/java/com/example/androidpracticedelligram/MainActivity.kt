package com.example.androidpracticedelligram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidpracticedelligram.Activity_01_TextView_EditText_Button.Activity_textview
import com.example.androidpracticedelligram.activity_02_checkbox_seekbar_switch_radio_dropdown.Activity_checkbox
import com.example.androidpracticedelligram.activity_03_webview.Activity_webview
import com.example.androidpracticedelligram.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.btn1.setOnClickListener {
            val intent = Intent(this, Activity_textview::class.java)
            startActivity(intent)

        }
        binding.btn2.setOnClickListener {
            val intent = Intent(this, Activity_checkbox::class.java)
            startActivity(intent)
        }
        binding.btn3.setOnClickListener {
            val intent = Intent(this, Activity_webview ::class.java)
            startActivity(intent)
        }

        
    }



}