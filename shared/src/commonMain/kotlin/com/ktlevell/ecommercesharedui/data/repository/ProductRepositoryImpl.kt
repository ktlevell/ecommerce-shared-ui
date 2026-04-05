package com.ktlevell.ecommercesharedui.data.repository

import com.ktlevell.ecommercesharedui.data.remote.RemoteDataSource
import com.ktlevell.ecommercesharedui.domain.Product
import com.ktlevell.ecommercesharedui.repository.ProductRepository

class ProductRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : ProductRepository {

    override suspend fun getAllProducts(): Result<List<Product>> =
        runCatching {
            remoteDataSource.getProducts()
        }

    override suspend fun getProductById(id: String): Result<Product?> =
        runCatching {
            remoteDataSource.getProductById(id)
        }

    override suspend fun getProductsByCategory(category: String): Result<List<Product>> =
        runCatching {
            remoteDataSource.getProductsByCategory(category)
        }
}