package com.example.dz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dz.database.db
import com.example.dz.database.entity.Product
import kotlinx.android.synthetic.main.item_product.view.*


class ProductAdapter(private val productSet: List<Product>):
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder( view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product,parent,false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productSet.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        holder.itemView.productName.text = productSet[position].name
        holder.itemView.productPrise.text = productSet[position].price.toString()
        holder.itemView.productInStock.text = productSet[position].inStock.toString()

        holder.itemView.cardView.setOnClickListener {
            Toast.makeText(holder.itemView.context, productSet[position].name, Toast.LENGTH_SHORT).show()
        }
    }
}