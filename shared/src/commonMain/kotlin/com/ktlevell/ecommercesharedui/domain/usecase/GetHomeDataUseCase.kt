package com.ktlevell.ecommercesharedui.domain.usecase

import com.ktlevell.ecommercesharedui.domain.HomeData

class GetHomeDataUseCase(
    private val getTrendingProducts: GetTrendingProducts,
    private val getMostPopularProducts: GetPopularProducts,
    private val getPromotion: GetPromotionUseCase
) {
    suspend operator fun invoke(): Result<HomeData> = runCatching {
        val trendingProducts = getTrendingProducts().getOrDefault(emptyList())
        val mostPopularProducts = getMostPopularProducts().getOrDefault(emptyList())
        val promotion = getPromotion().getOrNull()

        HomeData(
            trendingProducts = trendingProducts,
            mostPopularProducts = mostPopularProducts,
            promotion = promotion
        )
    }
}