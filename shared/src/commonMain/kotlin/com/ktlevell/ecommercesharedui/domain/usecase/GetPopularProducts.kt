package com.ktlevell.ecommercesharedui.domain.usecase

import com.ktlevell.ecommercesharedui.domain.Product
import com.ktlevell.ecommercesharedui.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class GetPopularProducts(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(): Result<List<Product>> {
        return withContext(Dispatchers.IO) {
            runCatching {
                productRepository.getAllProducts()
                    .map { it.filter { it.isPopular } }
                    .getOrDefault(emptyList())
            }
        }
    }
}