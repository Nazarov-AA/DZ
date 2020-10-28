package com.example.dz.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dz.R
import com.example.dz.dto.Json
import com.example.dz.entity.Rates
import com.example.dz.mapers.RatesMappers
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_crypto.view.*

private val URL_IMG = "https://s2.coinmarketcap.com/static/img/coins/64x64/"



//class CryptoAdapter(private var cryptoSet : List<Rates>):
class CryptoAdapter():
        RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>(){


    private var cryptoSet = ArrayList<Rates>()

    fun updateList(list: List<Rates>?) {
        cryptoSet = list as ArrayList<Rates>
        notifyDataSetChanged()
    }

    class CryptoViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_crypto,parent,false)
        return CryptoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cryptoSet.size
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {

        holder.itemView.name_coin.text = cryptoSet[position].name
        holder.itemView.price_coin.text = cryptoSet[position].price.toString().plus("$")
        holder.itemView.persent_coin.text = cryptoSet[position].percentChange24h.toString().plus("%")

        if (cryptoSet[position].percentChange24h > 0) holder.itemView.persent_coin.setTextColor(Color.GREEN)
        else holder.itemView.persent_coin.setTextColor(Color.RED)
        Picasso.get().load("$URL_IMG${cryptoSet[position].id}.png")
            .into(holder.itemView.image_coin)

    }


}