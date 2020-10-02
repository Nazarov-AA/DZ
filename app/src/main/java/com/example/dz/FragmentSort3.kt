package com.example.dz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_sort_1.*

class FragmentSort3: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sort_1,container,false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        if (ListCoffee.instance.coffees.isNotEmpty()){
            nameValue01.text = ListCoffee.instance.coffees[2].name
            coastValue01.text = ListCoffee.instance.coffees[2].cost.toString()
            if (ListCoffee.instance.coffees[2].url.isNotEmpty()) {
                Picasso.get().load(ListCoffee.instance.coffees[2].url).into(imageView01)
            }
        }
    }


}