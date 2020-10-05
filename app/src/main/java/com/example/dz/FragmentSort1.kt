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



        if (instance.coffees.size >= 1 && !instance.coffees[0].name.isNullOrEmpty()
            && !instance.coffees[0].cost.isNullOrEmpty()
            && !instance.coffees[0].url.isNullOrEmpty()){

            nameValue01.text = "Название: "+instance.coffees[0].name
            coastValue01.text = "Цена: " + instance.coffees[0].cost
            Picasso.get().load(instance.coffees[0].url).into(imageView01)
        }else Picasso.get().load("https://i.ytimg.com/vi/UJ8Zge_3Nqs/maxresdefault.jpg").into(imageView01)
    }


}