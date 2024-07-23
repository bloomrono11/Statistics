package com.lu.statistics

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"

        const val NO_SELECT = "No Selection"


        //Primary for stats
        const val SUM = "Sum"
        const val AVERAGE = "Average"
        const val MEDIAN = "Median"

        const val CHOOSE_OPTION = "Please select an option"
    }

    private val options = arrayOf(NO_SELECT, SUM, AVERAGE, MEDIAN)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this

        val spinnerPrimary: Spinner = findViewById(R.id.spPrimaryOption)

        spinnerPrimary.adapter =
            ArrayAdapter(context, android.R.layout.simple_list_item_1, options)

        spinnerPrimary.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                handlePrimarySpinnerSelection(position, context)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    fun handlePrimarySpinnerSelection(
        position: Int,
        context: Context
    ) {
        val value = options[position]
        Log.i(TAG, value)
        //Toast.makeText(context, value, Toast.LENGTH_SHORT).show()

        when (value) {
            NO_SELECT -> {
                Toast.makeText(context, CHOOSE_OPTION, Toast.LENGTH_SHORT).show()
            }

            SUM -> {
                handleStatSelection(value, 5, this)
            }

            AVERAGE -> {
                handleStatSelection(value, 5, this)
            }

            MEDIAN -> {
                handleStatSelection(value, 7, this)
            }
        }
    }

    fun handleStatSelection(textSelected: String, count: Int, context: Context) {
        if (textSelected == NO_SELECT) {
            Toast.makeText(context, CHOOSE_OPTION, Toast.LENGTH_SHORT).show()
            return
        }
        val intent: Intent = Intent(context, StatActivity::class.java)
        intent.putExtra("subHeading", textSelected)
        intent.putExtra("showNumbers", count)
        startActivity(intent)
    }

}
