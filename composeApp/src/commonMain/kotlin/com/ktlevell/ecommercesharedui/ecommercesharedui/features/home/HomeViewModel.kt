package com.ktlevell.ecommercesharedui.ecommercesharedui.features.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ktlevell.ecommercesharedui.domain.usecase.GetHomeDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getHomeDataUseCase: GetHomeDataUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Idle)
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading
            try {
                val result = getHomeDataUseCase()
                println("UseCase result: $result") // debug
                _uiState.value = result.fold(
                    onSuccess = { HomeUiState.Success(it) },
                    onFailure = {
                        println("Error: ${it.message}")
                        HomeUiState.Error(it.message ?: "Unknown error")
                    }
                )
            } catch (e: Exception) {
                e.printStackTrace()
                _uiState.value = HomeUiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}