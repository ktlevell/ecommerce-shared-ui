package com.ktlevell.ecommercesharedui.ecommercesharedui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ktlevell.ecommercesharedui.ecommercesharedui.navigation.AppNavHost
import com.ktlevell.ecommercesharedui.theme.AppTheme

@Composable
fun App() {
    AppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AppNavHost()
        }
    }
}