package com.example.dz

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dz.ListCoffee.Companion.instance
import kotlinx.android.synthetic.main.fragment_add_coffee.*

class FragmentAddCoffee : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_coffee,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        b_add_coffee.setOnClickListener {

            instance.coffees.add(Coffee(inputURL.text.toString(), inputName.text.toString(), inputCoast.text.toString()))

            inputURL.text.clear()
            inputName.text.clear()
            inputCoast.text.clear()


        }
    }

}