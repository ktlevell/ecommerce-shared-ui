package com.ktlevell.ecommercesharedui.ecommercesharedui.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ktlevell.ecommercesharedui.domain.usecase.GetHomeDataUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    private val getHomeDataUseCase: GetHomeDataUseCase
) : ViewModel() {

    val uiState: StateFlow<HomeUiState> = flow {
        val result = getHomeDataUseCase()
        val nextState = result.fold(
            onSuccess = { HomeUiState.Success(it) },
            onFailure = { HomeUiState.Error(it.message ?: "Unknown error") }
        )
        emit(nextState)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = HomeUiState.Loading
    )
}