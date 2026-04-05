package com.ktlevell.ecommercesharedui.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Promotion (
    val id: String,
    val title: String,
    val subtitle: String,
    val discount: Int,
    @SerialName("image")
    val imageUrl: String
)