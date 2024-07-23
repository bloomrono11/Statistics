package com.lu.statistics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.lu.statistics.MainActivity.Companion.AVERAGE
import com.lu.statistics.MainActivity.Companion.MEDIAN
import com.lu.statistics.MainActivity.Companion.SUM

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "subHeading"

/**
 * A simple [Fragment] subclass.
 * Use the [StatFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StatFragment : Fragment() {
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_stat, container, false)
        val calculateBtn: Button = inflate.findViewById(R.id.calBtn)
        val resultTV: TextView = inflate.findViewById(R.id.statResultTV)

        val edTxt1: EditText = inflate.findViewById(R.id.edTxt1)
        val edTxt2: EditText = inflate.findViewById(R.id.edTxt2)
        val edTxt3: EditText = inflate.findViewById(R.id.edTxt3)
        val edTxt4: EditText = inflate.findViewById(R.id.edTxt4)
        val edTxt5: EditText = inflate.findViewById(R.id.edTxt5)
        val edTxt6: EditText = inflate.findViewById(R.id.edTxt6)
        val edTxt7: EditText = inflate.findViewById(R.id.edTxt7)


        val subHead: String = param1.toString()

        when (subHead) {
            SUM, MEDIAN -> {
                edTxt6.visibility = View.VISIBLE
                edTxt7.visibility = View.VISIBLE
            }

            AVERAGE -> {
                edTxt6.visibility = View.INVISIBLE
                edTxt7.visibility = View.INVISIBLE
            }
        }

        calculateBtn.setOnClickListener {
            when (subHead) {
                SUM -> {

                    val sum = edTxt1.text.toString().toFloat() + edTxt2.text.toString()
                        .toFloat() + edTxt3.text.toString().toFloat() + edTxt4.text.toString()
                        .toFloat() + edTxt5.text.toString().toFloat() + edTxt6.text.toString()
                        .toFloat() + edTxt7.text.toString().toFloat()

                    resultTV.text =
                        "Sum is " + sum + "  units"
                }

                MEDIAN -> {
                    val num1 = edTxt1.text.toString().toFloat()
                    val num2 = edTxt2.text.toString().toFloat()
                    val num3 = edTxt3.text.toString().toFloat()
                    val num4 = edTxt4.text.toString().toFloat()
                    val num5 = edTxt5.text.toString().toFloat()
                    val num6 = edTxt6.text.toString().toFloat()
                    val num7 = edTxt7.text.toString().toFloat()


                    val list = arrayOf(num1, num2, num3, num4, num5, num6, num7).sorted()

                    val median = list.get(3)
                    resultTV.text =
                        "Median of the given numbers is " + median
                }

                AVERAGE -> {
                    var avg = edTxt1.text.toString().toFloat() + edTxt2.text.toString()
                        .toFloat() + edTxt3.text.toString().toFloat() + edTxt4.text.toString()
                        .toFloat() + edTxt5.text.toString().toFloat()

                    avg = avg/5
                    resultTV.text =
                        "Average is " + String.format("%.2f", avg)
                }
            }
        }
        return inflate
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StatFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StatFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}