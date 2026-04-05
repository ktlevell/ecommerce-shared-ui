package com.ktlevell.ecommercesharedui.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: String,
    val title: String,
    val description: String,
    val price: Double,
    val rating: Double,
    val category: String,
    val brand: String,
    val color: String,

    @SerialName("image")
    val thumbnail: String,
    @SerialName("is_trending")
    val isTrending: Boolean,
    @SerialName("is_popular")
    val isPopular: Boolean
)