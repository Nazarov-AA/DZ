package com.example.dz.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.dz.database.entity.Product

@Dao
interface ProductDao {

    @Insert
    suspend fun addProduct(product: Product)

    @Query("SELECT * FROM product_table")
    suspend fun getAllProduct(): List<Product>

    @Query("DELETE  FROM product_table")
    suspend fun clearDatabase()
}