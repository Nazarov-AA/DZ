package com.example.dz.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dz.database.dao.ProductDao
import com.example.dz.database.entity.Product

@Database(entities = arrayOf(Product::class),version = 1)
abstract class ProductDB: RoomDatabase() {

    abstract fun productDao() : ProductDao

}

object db{

    fun getDb(ctx: Context) =
        Room.databaseBuilder(ctx,ProductDB::class.java,"ProductDataBase").build()

}