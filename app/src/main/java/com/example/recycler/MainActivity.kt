package com.example.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val products = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeProducts()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ProductAdapter(products) { selectedProduct ->
            Toast.makeText(this, "Clicked ${selectedProduct.productName}", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adapter

        val viewCartButton: Button = findViewById(R.id.viewCartButton)
        viewCartButton.setOnClickListener {
            val cartItems = products.filter { it.isAddedToCart }
            val cartMessage = if (cartItems.isNotEmpty()) {
                "Added items to Cart: ${cartItems.joinToString { it.productName }}"
            } else {
                "Cart is empty."
            }
            Toast.makeText(this, cartMessage, Toast.LENGTH_LONG).show()
        }
    }

    private fun initializeProducts() {
        products.add(Product("iPad", "iPad Pro 11-inch", 400.0))
        products.add(Product("MacBook M3 Pro", "12-core CPU\n18-core GPU", 2500.00))
        products.add(Product("Dell Inspiron", "13th Gen Intel® Core™ i7", 1499.00))
        products.add(Product("Logitech Keyboard", "Logitech - PRO X\nTKL LIGHTSPEED Wireless", 199.00))
        products.add(Product("MacBook M3 Max", "14-core CPU\n30-core GPU", 3499.00))
    }
}