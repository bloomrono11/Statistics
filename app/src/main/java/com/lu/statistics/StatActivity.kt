package com.lu.statistics

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StatActivity : AppCompatActivity() {
    companion object {
        const val TAG = "StatActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stat)

        val subHead: TextView = findViewById(R.id.statSubheading)

        val text = intent.getStringExtra("subHeading")
        subHead.text = text

        Log.i(TAG, "data received for sub heading" + subHead.text)


        val statFragment = StatFragment()
        val fragBundle = Bundle()

        //Stat Fragment
        fragBundle.putString("subHeading", text)
        statFragment.arguments = fragBundle

        //Formula Fragment
        val formulaFrag = FormulaFragment()
        formulaFrag.arguments = fragBundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentHolder, statFragment)
            .setReorderingAllowed(true)
            .commit()

        val formulaBtn: Button = findViewById(R.id.formulaBtn)
        formulaBtn.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentHolder, formulaFrag)
                .addToBackStack(null)
                .commit()
        }

        val statBtn: Button = findViewById(R.id.statFragBtn)
        statBtn.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentHolder, statFragment)
                .addToBackStack(null)
                .commit()
        }
    }

}
