package com.ktlevell.ecommercesharedui.di

import com.ktlevell.ecommercesharedui.domain.usecase.GetHomeDataUseCase
import com.ktlevell.ecommercesharedui.domain.usecase.GetPopularProducts
import com.ktlevell.ecommercesharedui.domain.usecase.GetPromotionUseCase
import com.ktlevell.ecommercesharedui.domain.usecase.GetTrendingProducts
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetTrendingProducts)
    factoryOf(::GetPopularProducts)
    factoryOf(::GetPromotionUseCase)
    factoryOf(::GetHomeDataUseCase)
}