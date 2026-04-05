package com.ktlevell.ecommercesharedui.repository

import com.ktlevell.ecommercesharedui.domain.Product

interface ProductRepository {
    suspend fun getAllProducts(): Result<List<Product>>
    suspend fun getProductById(id: String): Result<Product?>
    suspend fun getProductsByCategory(category: String): Result<List<Product>>
}