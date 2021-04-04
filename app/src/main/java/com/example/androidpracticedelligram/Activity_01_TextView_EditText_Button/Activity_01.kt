package com.example.androidpracticedelligram.Activity_01_TextView_EditText_Button

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.androidpracticedelligram.R
import com.google.android.material.textfield.TextInputEditText

class Activity_01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_01)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar?.title = "Android view components"
        toolbar?.navigationIcon = ContextCompat.getDrawable(this,R.drawable.ic_baseline_arrow_back_24)
        toolbar?.setNavigationOnClickListener {
            Toast.makeText(applicationContext,"Navigation icon was clicked",Toast.LENGTH_SHORT).show()
            finish()
        }


        val etUsername = findViewById<EditText>(R.id.editText);
        val etPassword = findViewById<TextInputEditText>(R.id.textInputEdittext)
        val viewAll = findViewById<TextView>(R.id.viewAll);

        val submit = findViewById<Button>(R.id.showTVBtn)
        if (submit != null && etPassword != null && etUsername != null) {
            submit.setOnClickListener {
                val username = etUsername.text.toString()
                val password = etPassword.text.toString()

                Toast.makeText(applicationContext,
                        "Text 1:  $username, Text2: $password", Toast.LENGTH_SHORT).show()

                viewAll.text = "Text from EditText: $username,\n Text from InputEditText: $password"

            }
        }

    }
}