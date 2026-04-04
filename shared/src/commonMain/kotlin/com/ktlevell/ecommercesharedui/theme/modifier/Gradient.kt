package com.ktlevell.ecommercesharedui.theme.modifier

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun Modifier.categoryGradient(
    baseColor: Color
): Modifier = this.then(
    Modifier.background(
        brush = Brush.verticalGradient(
            colors = listOf(
                baseColor,
                baseColor.copy(alpha = 0.2f)
            )
        )
    )
)