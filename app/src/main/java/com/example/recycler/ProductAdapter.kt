package com.example.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ProductAdapter(private val products: List<Product>, private val onItemClick: (Product) -> Unit) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productNameTextView: TextView = itemView.findViewById(R.id.productName)
        val productDescriptionTextView: TextView = itemView.findViewById(R.id.productDescription)
        val costTextView: TextView = itemView.findViewById(R.id.productCost)
        val addToCartButton: Button = itemView.findViewById(R.id.addButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentProduct = products[position]

        holder.productNameTextView.text = currentProduct.productName
        holder.productDescriptionTextView.text = currentProduct.productDescription
        holder.costTextView.text = "$${currentProduct.cost}"

        holder.addToCartButton.setOnClickListener {
            currentProduct.isAddedToCart = !currentProduct.isAddedToCart
            onItemClick.invoke(currentProduct)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }
}
