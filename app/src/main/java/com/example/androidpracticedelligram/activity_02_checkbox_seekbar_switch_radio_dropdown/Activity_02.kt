package com.example.androidpracticedelligram.activity_02_checkbox_seekbar_switch_radio_dropdown

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.example.androidpracticedelligram.R

class Activity_02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_02)

        // Toolbar init and set
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar?.subtitle = "Android view components"
        toolbar?.navigationIcon = ContextCompat.getDrawable(this,R.drawable.ic_baseline_arrow_back_24)
        toolbar?.setNavigationOnClickListener {
            finish()
        }


        //value init
        val submit = findViewById<Button>(R.id.showDetailButton)




        submit.setOnClickListener {
            cheboxListener()
            radioButtonListener()
            ratingBarListener()
        }

        val sw1 = findViewById<Switch>(R.id.switch1)
        sw1?.setOnCheckedChangeListener { _, isChecked ->
            val message = if (isChecked) "Switch:ON" else "Switch:OFF"
            Toast.makeText(
                this, message,
                Toast.LENGTH_SHORT
            ).show()
        }


    }

    private fun ratingBarListener() {
        val rBar = findViewById<RatingBar>(R.id.rBar)
        val msg = rBar.rating.toString()
        Toast.makeText(applicationContext,
            "Rating is: "+msg, Toast.LENGTH_SHORT).show()
    }

    private fun radioButtonListener() {
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        val selectedOption: Int = radioGroup!!.checkedRadioButtonId

        // Assigning id of the checked radio button
        val radioButton = findViewById<RadioButton>(selectedOption)

        // Displaying text of the checked radio button in the form of toast
        Toast.makeText(applicationContext, radioButton.text, Toast.LENGTH_SHORT).show()


    }

    private fun cheboxListener() {
        val check1 = findViewById<CheckBox>(R.id.check1)
        val check2 = findViewById<CheckBox>(R.id.check2)
        val check3 = findViewById<CheckBox>(R.id.check3)

        //Checkbox
        val result = StringBuilder()
        result.append("Selected Items")
        if ( check1 .isChecked) {
            result.append("\n Click on check1")

        }
        if ( check2 .isChecked) {
            result.append("\n Click on check2")
        }
        if ( check3 .isChecked) {
            result.append("\n Click on check3")
        }

        Toast.makeText(applicationContext, result.toString(), Toast.LENGTH_SHORT).show()
    }
}