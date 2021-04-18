package com.example.androidpracticedelligram.ui_coordinator_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidpracticedelligram.R
import com.example.androidpracticedelligram.databinding.ActivityCoordinatorLayoutBinding

class CoordinatorLayoutActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityCoordinatorLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityCoordinatorLayoutBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initVal()
    }

    private fun initVal() {


    }
}