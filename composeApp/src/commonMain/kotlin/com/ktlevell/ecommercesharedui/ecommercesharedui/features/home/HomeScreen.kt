package com.ktlevell.ecommercesharedui.ecommercesharedui.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.R
import com.ktlevell.ecommercesharedui.theme.DiamondBlur
import org.jetbrains.compose.resources.stringResource

@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Transparent
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DiamondBlur)
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
           Text(
               text = "Home Screen",
           )
        }
    }
}
