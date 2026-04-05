package com.ktlevell.ecommercesharedui.ecommercesharedui.features.home

import com.ktlevell.ecommercesharedui.domain.HomeData

sealed interface HomeUiState {
    object Loading : HomeUiState
    data class Success(val data: HomeData) : HomeUiState
    data class Error(val message: String) : HomeUiState
}