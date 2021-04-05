package com.example.androidpracticedelligram.activity_03_webview

import android.os.Bundle
import com.example.androidpracticedelligram.BaseActivity
import com.example.androidpracticedelligram.databinding.Activity03Binding

class Activity_03 : BaseActivity() {

    private lateinit var binding: Activity03Binding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity03Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initToolbar("Webview")



        binding.textsadf.text = "View binding"

    }
}