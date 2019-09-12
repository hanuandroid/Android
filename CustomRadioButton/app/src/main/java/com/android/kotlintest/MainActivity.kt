package com.android.kotlintest

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var radioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup = findViewById(R.id.radio_group)

        for (i in 1..5) {

            if (i == 3) {
                radioGroup.addView(createCustomRadioButton(this, "Radio Button $i", i, true))
            } else {
                radioGroup.addView(createCustomRadioButton(this, "Radio Button $i", i, false))
            }

        }

        radioGroup.setOnCheckedChangeListener { group, checkedId ->

            // find the radiobutton by returned id
            val radioSelected = findViewById<View>(checkedId) as RadioButton

            Toast.makeText(
                this@MainActivity,
                radioSelected.getText(), Toast.LENGTH_SHORT
            ).show()

        }
    }

    private fun createCustomRadioButton(context: Context, title: String, id: Int, checked: Boolean): RadioButton {
        val inflater = LayoutInflater.from(context)
        val v = inflater.inflate(R.layout.layout_radio_button, null)
        val radioButton = v.findViewById(R.id.phone_radio) as RadioButton
        radioButton.layoutParams =
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        radioButton.text = title
        radioButton.id = id
        radioButton.isChecked = checked

        return radioButton
    }
}
