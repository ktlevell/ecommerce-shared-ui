package com.ktlevell.ecommercesharedui.ecommercesharedui.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ktlevell.ecommercesharedui.theme.AppTheme
import com.ktlevell.ecommercesharedui.theme.DiamondBlur
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeRoot(
    viewModel: HomeViewModel = koinViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(state) {
        if (state is HomeUiState.Idle) {
            viewModel.loadData()
        }
    }

    when(state) {
        is HomeUiState.Idle, HomeUiState.Loading -> {
            viewModel.loadData()
        }
        is HomeUiState.Success -> {
            HomeScreen(
                homeState = state
            )
        }
        is HomeUiState.Error -> {}
    }

}

@Composable
fun HomeScreen(
    homeState: HomeUiState,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {

        },
        modifier = modifier.fillMaxSize(),
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(DiamondBlur)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(26.dp))

                when (homeState) {
                    is HomeUiState.Loading, is HomeUiState.Idle -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Loading...")
                        }
                    }

                    is HomeUiState.Success -> {
                        HomeContent(
                            modifier = Modifier.fillMaxSize(),
                            trendingProducts = homeState.data.trendingProducts,
                            popularProducts = homeState.data.mostPopularProducts,
                            promotion = homeState.data.promotion,
                            onPromotionClick = { /* ação */ },
                            onAddClick = { product -> /* adicionar ao carrinho */ },
                            onCardClick = { product -> /* abrir detalhe */ }
                        )
                    }

                    is HomeUiState.Error -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = homeState.message)
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    AppTheme {
        HomeScreen(
            homeState = HomeUiState.Idle
        )
    }
}