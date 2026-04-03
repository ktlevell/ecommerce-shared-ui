package com.ktlevell.ecommercesharedui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

val LightColorScheme = lightColorScheme(
    primary = PrimaryColor,
    onPrimary = White,
    secondary = White,
    onSecondary = Black,
    onPrimaryFixedVariant = Black,
    outlineVariant = NC40,
    tertiary = NC70,
    surface = White,
    onSurface = Black,
    onSurfaceVariant = NC40,
)


@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        content = content,
        typography = Typography
    )
}

