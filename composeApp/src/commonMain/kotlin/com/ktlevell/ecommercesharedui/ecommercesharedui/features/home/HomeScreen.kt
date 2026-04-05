package com.ktlevell.ecommercesharedui.ecommercesharedui.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import com.ktlevell.ecommercesharedui.components.TopAppBar
import com.ktlevell.ecommercesharedui.theme.AppTheme
import com.ktlevell.ecommercesharedui.theme.DiamondBlur
import com.ktlevell.ecommercesharedui.theme.Resources
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeRoot(
    viewModel: HomeViewModel = koinViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        homeState = state
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeState: HomeUiState,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                actions = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(
                            onClick = { }
                        ) {
                            Icon(
                                painter = painterResource(Resources.Icons.Outlined.Menu),
                                contentDescription = "Menu",
                                modifier = Modifier
                                    .size(24.dp)
                            )
                        }

                        Row(
                            modifier = Modifier,
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            IconButton(
                                onClick = { }
                            ) {
                                Icon(
                                    painter = painterResource(Resources.Icons.Outlined.Search),
                                    contentDescription = "Menu",
                                    modifier = Modifier
                                        .size(24.dp)
                                )
                            }

                        }
                    }
                }
            )
        },
        modifier = modifier
            .fillMaxSize(),
        contentWindowInsets = WindowInsets(0,0,0,0)
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
                Spacer(modifier = Modifier.height(12.dp))

                when (homeState) {
                    is HomeUiState.Loading -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(
                                color = MaterialTheme.colorScheme.primary
                            )
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
            homeState = HomeUiState.Loading
        )
    }
}