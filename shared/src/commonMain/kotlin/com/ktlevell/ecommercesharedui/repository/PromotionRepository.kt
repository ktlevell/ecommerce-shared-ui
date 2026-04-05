package com.ktlevell.ecommercesharedui.repository

import com.ktlevell.ecommercesharedui.domain.Promotion

interface PromotionRepository {
    suspend fun getPromotion(): Result<Promotion>
}