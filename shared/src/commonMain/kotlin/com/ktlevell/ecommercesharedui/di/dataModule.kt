package com.ktlevell.ecommercesharedui.di

import com.ktlevell.ecommercesharedui.data.remote.RemoteDataSource
import com.ktlevell.ecommercesharedui.data.remote.RemoteDataSourceImpl
import com.ktlevell.ecommercesharedui.data.repository.CategoryRepositoryImpl
import com.ktlevell.ecommercesharedui.data.repository.ProductRepositoryImpl
import com.ktlevell.ecommercesharedui.data.repository.PromotionRepositoryImpl
import com.ktlevell.ecommercesharedui.repository.CategoryRepository
import com.ktlevell.ecommercesharedui.repository.ProductRepository
import com.ktlevell.ecommercesharedui.repository.PromotionRepository
import org.koin.dsl.module

val dataModule = module {
    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }
    single<ProductRepository> { ProductRepositoryImpl(get()) }
    single<PromotionRepository> { PromotionRepositoryImpl(get()) }
    single<CategoryRepository> { CategoryRepositoryImpl(get()) }
}