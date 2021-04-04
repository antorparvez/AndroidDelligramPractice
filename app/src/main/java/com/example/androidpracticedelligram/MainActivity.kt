package com.example.androidpracticedelligram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.androidpracticedelligram.Activity_01_TextView_EditText_Button.Activity_01


class MainActivity : AppCompatActivity() {

    lateinit var button1 : Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.btn1);




        button1.setOnClickListener {
            openTargetedActivity(Activity_01::class.java)
        }

        
    }

    private fun openTargetedActivity(TargetedActivity: Class<Activity_01>) {

        val intent = Intent(this, TargetedActivity)
        startActivity(intent)


    }


}