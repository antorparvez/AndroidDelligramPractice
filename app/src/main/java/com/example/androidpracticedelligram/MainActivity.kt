package com.example.androidpracticedelligram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import com.example.androidpracticedelligram.Activity_01_TextView_EditText_Button.Activity_01
import com.example.androidpracticedelligram.activity_02_checkbox_seekbar_switch_radio_dropdown.Activity_02
import com.example.androidpracticedelligram.activity_03_webview.Activity_03
import com.example.androidpracticedelligram.databinding.Activity03Binding
import com.example.androidpracticedelligram.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.btn1.setOnClickListener {
            val intent = Intent(this, Activity_01::class.java)
            startActivity(intent)

        }
        binding.btn2.setOnClickListener {
            val intent = Intent(this, Activity_02::class.java)
            startActivity(intent)
        }
        binding.btn3.setOnClickListener {
            val intent = Intent(this, Activity_03 ::class.java)
            startActivity(intent)
        }

        
    }



}