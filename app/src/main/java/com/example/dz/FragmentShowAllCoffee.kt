package com.example.dz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_show_all_coffee.*

class FragmentShowAllCoffee : Fragment(){

    val frSort1 = FragmentSort1()
    val frSort2 = FragmentSort2()
    val frSort3 = FragmentSort3()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_all_coffee,container,false)

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        button_sort_1.setOnClickListener {

            childFragmentManager.beginTransaction().replace(R.id.fragment_container,frSort1).commit()
        }

        button_sort_2.setOnClickListener {

            childFragmentManager.beginTransaction().replace(R.id.fragment_container,frSort2).commit()
        }

        button_sort_3.setOnClickListener {

            childFragmentManager.beginTransaction().replace(R.id.fragment_container,frSort3).commit()
        }

    }

}