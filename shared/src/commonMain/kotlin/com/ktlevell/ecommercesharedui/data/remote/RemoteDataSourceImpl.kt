package com.ktlevell.ecommercesharedui.data.remote

import com.ktlevell.ecommercesharedui.domain.Category
import com.ktlevell.ecommercesharedui.domain.Product
import com.ktlevell.ecommercesharedui.domain.Promotion
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from

class RemoteDataSourceImpl(
    private val client: SupabaseClient
) : RemoteDataSource {
    override suspend fun getCategories(): List<Category> {
        return client
            .from("categories")
            .select()
            .decodeList<Category>()
    }


    override suspend fun getCategoryById(id: String): Category? {
        return client
            .from("categories")
            .select {
                filter {
                    eq("id", id)
                }
            }
            .decodeSingleOrNull()
    }

    override suspend fun getProducts(): List<Product> {
        return client
            .from("products")
            .select()
            .decodeList<Product>()
    }

    override suspend fun getProductById(id: String): Product? {
        return client
            .from("products")
            .select {
                filter {
                    eq("id", id)
                }
            }
            .decodeSingleOrNull()
    }

    override suspend fun getProductsByCategory(category: String): List<Product> {
        return client
            .from("products")
            .select {
                filter {
                    eq("category", category)
                }
            }
            .decodeList()
    }

    override suspend fun getPromotion(): Promotion {
        return client
            .from("promotions")
            .select()
            .decodeSingle()
    }

}