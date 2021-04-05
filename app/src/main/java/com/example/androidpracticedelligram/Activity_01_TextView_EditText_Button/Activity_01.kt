package com.example.androidpracticedelligram.Activity_01_TextView_EditText_Button

import android.os.Bundle
import android.widget.Toast
import com.example.androidpracticedelligram.BaseActivity
import com.example.androidpracticedelligram.databinding.Activity01Binding

class Activity_01 : BaseActivity() {

    //View Binding
    private lateinit var binding: Activity01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewBindning
        binding = Activity01Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // init_toolbar from BaseActivity
        initToolbar("TextView_EditText_Button")


        if (binding.showTVBtn != null && binding.textInputEdittext != null && binding.editText != null) {
            binding.showTVBtn .setOnClickListener {
                val username = binding.editText.text.toString()
                val password = binding.textInputEdittext.text.toString()

                Toast.makeText(applicationContext,
                        "Text 1:  $username, Text2: $password", Toast.LENGTH_SHORT).show()

                binding.viewAll.text = "Text from EditText: $username,\n Text from InputEditText: $password"

            }
        }

    }
}