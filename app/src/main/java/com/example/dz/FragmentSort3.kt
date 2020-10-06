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


        if (ListCoffee.instance.coffees.size >= 3 && !ListCoffee.instance.coffees[2].name.isNullOrEmpty()
            && !ListCoffee.instance.coffees[2].cost.isNullOrEmpty()
            && !ListCoffee.instance.coffees[2].url.isNullOrEmpty()){

            nameValue01.text = "Название: " + ListCoffee.instance.coffees[2].name
            coastValue01.text = "Цена: " + ListCoffee.instance.coffees[2].cost
            Picasso.get().load(ListCoffee.instance.coffees[2].url).into(imageView01)
        }else Picasso.get().load("https://i.ytimg.com/vi/UJ8Zge_3Nqs/maxresdefault.jpg").into(imageView01)

    }


}