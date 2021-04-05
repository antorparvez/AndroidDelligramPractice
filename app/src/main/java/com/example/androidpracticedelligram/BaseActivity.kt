package com.example.androidpracticedelligram

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

open class BaseActivity : AppCompatActivity() {

     fun initToolbar(subTitle: String) {
         // Toolbar init and set
         val toolbar = findViewById<Toolbar>(R.id.toolbar)
         setSupportActionBar(toolbar)
         toolbar?.subtitle = subTitle
         toolbar?.navigationIcon = ContextCompat.getDrawable(this,R.drawable.ic_baseline_arrow_back_24)
         toolbar?.setNavigationOnClickListener {
             finish()
         }
    }
}