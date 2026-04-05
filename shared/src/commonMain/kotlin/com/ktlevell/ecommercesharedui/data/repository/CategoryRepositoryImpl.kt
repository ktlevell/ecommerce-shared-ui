package com.ktlevell.ecommercesharedui.data.repository

import com.ktlevell.ecommercesharedui.data.remote.RemoteDataSource
import com.ktlevell.ecommercesharedui.domain.Category
import com.ktlevell.ecommercesharedui.repository.CategoryRepository

class CategoryRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : CategoryRepository {

    override suspend fun getAllCategories(): Result<List<Category>> =
        runCatching {
            remoteDataSource.getCategories()
        }

    override suspend fun getCategoryById(id: String): Result<Category?> =
        runCatching {
            remoteDataSource.getCategoryById(id)
        }
}