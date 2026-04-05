package com.ktlevell.ecommercesharedui.data.remote

import com.ktlevell.ecommercesharedui.domain.Category
import com.ktlevell.ecommercesharedui.domain.Product
import com.ktlevell.ecommercesharedui.domain.Promotion

interface RemoteDataSource {
    suspend fun getCategories(): List<Category>
    suspend fun getCategoryById(id: String): Category?

    suspend fun getProducts(): List<Product>
    suspend fun getProductById(id: String): Product?
    suspend fun getProductsByCategory(category: String): List<Product>

    suspend fun getPromotion(): Promotion
}