package com.ktlevell.ecommercesharedui.repository

import com.ktlevell.ecommercesharedui.domain.Category


interface CategoryRepository {
    suspend fun getAllCategories(): Result<List<Category>>
    suspend fun getCategoryById(id: String): Result<Category?>
}