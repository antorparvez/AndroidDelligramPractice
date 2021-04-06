package com.example.androidpracticedelligram.ui_checkbox

import android.os.Bundle
import android.widget.*
import com.example.androidpracticedelligram.BaseActivity
import com.example.androidpracticedelligram.R
import com.example.androidpracticedelligram.databinding.ActivityCheckboxBinding

class CheckboxActivity : BaseActivity() {

    private lateinit var binding: ActivityCheckboxBinding
    var switchStage : String? = "Switch:OFF"
    var allText : String? ="Clicked Items: "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCheckboxBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initToolbar("Checkbox, Switch, RadioButton")

        binding.showDetailButton.setOnClickListener {
            checkBoxListener()
            radioButtonListener()
            ratingBarListener()
            saveValueTextView()
        }

        binding.switchBtn?.setOnCheckedChangeListener { _, isChecked ->
            switchStage = if (isChecked) "Switch:ON" else "Switch:OFF"
            Toast.makeText(
                    this, switchStage,
                    Toast.LENGTH_SHORT
            ).show()
        }


    }

    private fun saveValueTextView() {

        binding.clickDetailsTV.text = allText
        Toast.makeText(applicationContext, allText.toString(), Toast.LENGTH_SHORT).show()
        allText = "Clicked Items:"

    }

    private fun ratingBarListener() {
        val rBar = findViewById<RatingBar>(R.id.rateBar)
        val msg = rBar.rating.toString()
        allText = "$allText\n Rating is: \"$msg"

    }

    private fun radioButtonListener() {
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        val selectedOption: Int = radioGroup!!.checkedRadioButtonId

        // Assigning id of the checked radio button
        val radioButton = findViewById<RadioButton>(selectedOption)

        allText = "$allText\n ${radioButton.text}"


    }

    private fun checkBoxListener() {
        val check1 = findViewById<CheckBox>(R.id.check1)
        val check2 = findViewById<CheckBox>(R.id.check2)
        val check3 = findViewById<CheckBox>(R.id.check3)

        //Checkbox
        val result = StringBuilder()
        result.append("Selected Items")
        if (check1.isChecked) {
            result.append("\n Click on Check Box 1")

        }
        if (check2.isChecked) {
            result.append("\n Click on Check Box 2")
        }
        if (check3.isChecked) {
            result.append("\n Click on Check Box 3")
        }

        allText = "$allText\n $result \n$switchStage"


          }
}