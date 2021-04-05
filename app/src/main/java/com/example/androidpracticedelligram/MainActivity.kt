package com.example.androidpracticedelligram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import com.example.androidpracticedelligram.Activity_01_TextView_EditText_Button.Activity_01
import com.example.androidpracticedelligram.activity_02_checkbox_seekbar_switch_radio_dropdown.Activity_02


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       val button1=   findViewById<Button>(R.id.btn1)
       val button2=   findViewById<Button>(R.id.btn2)




        button1.setOnClickListener {
            val intent = Intent(this, Activity_01::class.java)
            startActivity(intent)

        }
        button2.setOnClickListener {
            val intent = Intent(this, Activity_02::class.java)
            startActivity(intent)
        }

        
    }



}