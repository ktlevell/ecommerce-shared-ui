package com.ktlevell.ecommercesharedui.data.repository

import com.ktlevell.ecommercesharedui.data.remote.RemoteDataSource
import com.ktlevell.ecommercesharedui.domain.Promotion
import com.ktlevell.ecommercesharedui.repository.PromotionRepository

class PromotionRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : PromotionRepository {

    override suspend fun getPromotion(): Result<Promotion> =
        runCatching {
            remoteDataSource.getPromotion()
        }
}