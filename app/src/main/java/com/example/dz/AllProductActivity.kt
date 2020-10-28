package com.example.dz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dz.Utils.launchForResult
import com.example.dz.Utils.launchIo
import com.example.dz.Utils.launchUi
import com.example.dz.database.dao.ProductDao
import com.example.dz.database.db
import com.example.dz.database.entity.Product
import com.example.dz.database.entity.productSet
import kotlinx.android.synthetic.main.activity_add_product.*
import kotlinx.android.synthetic.main.activity_all_product.*

class AllProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_product)

        val db: ProductDao = db.getDb(this).productDao()


                launchIo {
            launchForResult {
                var result: List<Product> = db.getAllProduct()

                launchUi {
                    val adapter = ProductAdapter(result)
                    productRecycler.adapter = adapter
                }
            }
        }

        productRecycler.layoutManager = LinearLayoutManager(this)
        productRecycler.hasFixedSize()

    }
}