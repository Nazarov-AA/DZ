package com.example.dz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dz.Utils.launchForResult
import com.example.dz.Utils.launchIo
import com.example.dz.Utils.launchUi
import com.example.dz.database.dao.ProductDao
import com.example.dz.database.db
import com.example.dz.database.entity.Product
import kotlinx.android.synthetic.main.activity_add_product.*
import kotlinx.android.synthetic.main.activity_registration.*


class AddProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        val db: ProductDao = db.getDb(this).productDao()

        buttonAdd.setOnClickListener {

            val name = textName.text.toString()
            val price = textPrice.text.toString().toDouble()
            val inStock = InStock.isChecked

            val product = Product(name, price, inStock)

            launchIo {
                db.addProduct(product)

            }


            launchIo {
                launchForResult {
                    val result: List<Product> = db.getAllProduct()

                    launchUi {
                        textResult.text = result.toString()
                    }
                }
            }

            textName.text.clear()
            textPrice.text.clear()
            InStock.clearFocus()

        }

        buttonShow.setOnClickListener {

            val myIntent = Intent(this,AllProductActivity::class.java)
            startActivity(myIntent)
        }

        buttonClear.setOnClickListener {
            launchIo {
                db.clearDatabase()
            }
        }


    }
}