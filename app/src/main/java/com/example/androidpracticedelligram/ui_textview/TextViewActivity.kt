package com.example.androidpracticedelligram.ui_textview

import android.os.Bundle
import android.widget.Toast
import com.example.androidpracticedelligram.BaseActivity
import com.example.androidpracticedelligram.databinding.ActivityTextviewBinding

class TextViewActivity : BaseActivity() {

    //View Binding
    private lateinit var binding: ActivityTextviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewBindning
        binding = ActivityTextviewBinding.inflate(layoutInflater)
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