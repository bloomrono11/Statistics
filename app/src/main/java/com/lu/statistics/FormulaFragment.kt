package com.lu.statistics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.lu.statistics.MainActivity.Companion.AVERAGE
import com.lu.statistics.MainActivity.Companion.MEDIAN
import com.lu.statistics.MainActivity.Companion.SUM

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "subHeading"

/**
 * A simple [Fragment] subclass.
 * Use the [FormulaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FormulaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val inflate = inflater.inflate(R.layout.fragment_formula, container, false)

        val subHead: String = param1.toString()
        val textView:TextView = inflate.findViewById(R.id.formulaTV)

        when (subHead) {
            SUM->{
                textView.text = "Sum of numbers based on a +B +c ... = x"
            }
            MEDIAN -> {
                textView.text = "Median is equal to n/2 +1 since we take 7 inputs where n is the total numbers"
            }

            AVERAGE -> {
                textView.text = "Average is equal to sum ofthe 5 numbers divided by 5"
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
         * @return A new instance of fragment FormulaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FormulaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}