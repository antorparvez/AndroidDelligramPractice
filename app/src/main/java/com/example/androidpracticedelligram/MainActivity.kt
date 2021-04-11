package com.example.androidpracticedelligram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidpracticedelligram.ui_textview.TextViewActivity
import com.example.androidpracticedelligram.ui_checkbox.CheckboxActivity
import com.example.androidpracticedelligram.ui_webview.WebviewActivity
import com.example.androidpracticedelligram.ui_datepicker.PickerActivity
import com.example.androidpracticedelligram.databinding.ActivityMainBinding
import com.example.androidpracticedelligram.ui_cardview.CardViewToastActivity
import com.example.androidpracticedelligram.ui_constraint_layout.ConstraintLayoutActivity
import com.example.androidpracticedelligram.ui_recylerview.RecyclerViewActivity
import com.example.androidpracticedelligram.ui_viewpager.ViewPagerActivity


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.textViewBtn.setOnClickListener {
            val intent = Intent(this, TextViewActivity::class.java)
            startActivity(intent)
        }

        binding.checkboxBtn.setOnClickListener {
            val intent = Intent(this, CheckboxActivity::class.java)
            startActivity(intent)
        }

        binding.webviewBtn.setOnClickListener {
            val intent = Intent(this, WebviewActivity::class.java)
            startActivity(intent)
        }

        binding.datePickerBtn.setOnClickListener {
            val intent = Intent(this, PickerActivity::class.java)
            startActivity(intent)
        }

        binding.viewPagerBtn.setOnClickListener {
            val intent = Intent(this, ViewPagerActivity::class.java)
            startActivity(intent)
        }

        binding.constLayoutBtn.setOnClickListener {
            val intent = Intent(this, ConstraintLayoutActivity::class.java)
            startActivity(intent)
        }


        binding.recyclerViewBtn.setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }


    }


}