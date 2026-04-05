package com.ktlevell.ecommercesharedui.domain

data class HomeData(
    val trendingProducts: List<Product>,
    val mostPopularProducts: List<Product>,
    val promotion: Promotion?,
)
