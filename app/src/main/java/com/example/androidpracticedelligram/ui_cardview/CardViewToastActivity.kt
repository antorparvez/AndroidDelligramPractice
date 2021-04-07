package com.example.androidpracticedelligram.ui_cardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import com.example.androidpracticedelligram.R
import com.example.androidpracticedelligram.databinding.ActivityCardviewBinding

class CardViewToastActivity : AppCompatActivity() {

    lateinit var binding: ActivityCardviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardviewBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.customTastBtn.setOnClickListener {
            customToast()
        }
    }

    private fun customToast() {
        val layout = layoutInflater.inflate(R.layout.custom_toast,findViewById(R.id.linearLayout))

        val myToast = Toast(applicationContext)
        myToast.duration = Toast.LENGTH_LONG
        myToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
        myToast.view = layout//setting the view of custom toast layout
        myToast.show()
    }
}