package com.ktlevell.ecommercesharedui.navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ktlevell.ecommercesharedui.theme.NC40

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    currentDestination: Destination,
    onDestinationClicked: (Destination) -> Unit
) {
    if (currentDestination.isTopLevelDestination) {
        NavigationBar(
            modifier = modifier
                .fillMaxWidth(),
            tonalElevation = 0.dp,
            containerColor = MaterialTheme.colorScheme.onPrimary,
            contentColor = MaterialTheme.colorScheme.onPrimaryFixedVariant,
            windowInsets = WindowInsets(0,0, 0, 0)
        ) {
            Destination.drawerDestinations.forEach { destination ->
                val isSelected = destination == currentDestination

                NavigationBarItem(
                    label = {
                        Text(
                            text = destination.title ?: "",
                            style = MaterialTheme.typography.bodySmall,
                        )
                    },
                    icon = {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = Destination.getIcon(destination),
                            contentDescription = destination.title,
                        )
                    },
                    selected = isSelected,
                    onClick = { onDestinationClicked(destination) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedTextColor = MaterialTheme.colorScheme.primary,
                        unselectedTextColor = MaterialTheme.colorScheme.outlineVariant,
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = MaterialTheme.colorScheme.outlineVariant,
                        indicatorColor = Color.Transparent,
                    )
                )
            }
        }
    }
}
