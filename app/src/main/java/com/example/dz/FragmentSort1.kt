package com.example.dz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dz.ListCoffee.Companion.instance
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_sort_1.*

class FragmentSort1: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sort_1,container,false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        if (instance.coffees.isNotEmpty()){
            nameValue01.text = instance.coffees[0].name
            coastValue01.text = instance.coffees[0].cost.toString()
            if (instance.coffees[0].url.isNotEmpty()) {
                Picasso.get().load(instance.coffees[0].url).into(imageView01)
            }
        }
    }


}