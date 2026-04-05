package com.ktlevell.ecommercesharedui.domain.usecase

import com.ktlevell.ecommercesharedui.domain.Promotion
import com.ktlevell.ecommercesharedui.repository.PromotionRepository

class GetPromotionUseCase(
    private val promotionRepository: PromotionRepository
) {
    suspend operator fun invoke(): Result<Promotion> = promotionRepository.getPromotion()
}
