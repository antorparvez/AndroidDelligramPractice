package com.example.androidpracticedelligram.ui_cardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import com.example.androidpracticedelligram.BaseActivity
import com.example.androidpracticedelligram.R
import com.example.androidpracticedelligram.databinding.ActivityCardviewBinding

class CardViewToastActivity : BaseActivity() {

    lateinit var binding: ActivityCardviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initToolbar("Custom Toast, Cardview")

        setValueByViewBinding()

        binding.customTastBtn.setOnClickListener {
            customToast("This ia a custom Toast")
        }
    }

    private fun setValueByViewBinding() {

        binding.cardViewSubmitButton.setOnClickListener {
            val cardviewET = binding.cardViewET.text


            if (isNullOrEmpty(cardviewET.toString()))

                customToast("Please write something")

            else
            {
                binding.cardViewTV.text = cardviewET
                binding.cardViewET.setText("")
            }

        }


    }

    private fun customToast(toastMsg: String) {

        val layout = layoutInflater.inflate(R.layout.custom_toast,findViewById(R.id.linearLayout))
        val tv : TextView = layout.findViewById(R.id.custom_toast_message)
        tv.text = toastMsg
        val myToast = Toast(applicationContext)
        myToast.duration = Toast.LENGTH_LONG
        myToast.setText("Asdfasdffdsa")
        myToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
        myToast.view = layout//setting the view of custom toast layout
        myToast.show()
    }


    fun isNullOrEmpty(str: String?): Boolean {
        if (str != null && str.trim().isNotEmpty())
            return false
        return true
    }


}
