package com.example.dz.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "product_table")
data class Product(

    @ColumnInfo(name = "product_name")
    val name: String,

    @ColumnInfo(name = "product_price")
    val price: Double,

    @ColumnInfo(name = "product_inStock")
    val inStock: Boolean
)  {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}

object productSet{



    fun getProducts() = listOf<Product>(
        Product("Petya", 40.0,false),
        Product("Pet", 41.0,false)


    )
}