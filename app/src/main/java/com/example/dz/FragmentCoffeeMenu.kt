package com.example.dz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_coffee_menu.*

class FragmentCoffeeMenu : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_coffee_menu,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        button_add_coffee.setOnClickListener {
            val nav = findNavController()

            nav.navigate(R.id.show_fragment2)
        }

        button_show_all_coffee.setOnClickListener {
            val nav = findNavController()

            nav.navigate(R.id.show_fragment3)
        }

    }

}