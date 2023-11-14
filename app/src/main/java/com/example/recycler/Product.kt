package com.example.recycler

data class Product(val productName: String, val productDescription: String, val cost: Double, var isAddedToCart: Boolean = false)