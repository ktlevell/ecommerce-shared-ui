package com.ktlevell.ecommercesharedui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.ktlevell.ecommercesharedui.theme.Resources
import org.jetbrains.compose.resources.painterResource
import kotlinx.serialization.Serializable

sealed interface Destination {
    val isTopLevelDestination: Boolean
    val title: String? get() = null

    @Serializable
    data object Home : Destination {
        override val isTopLevelDestination = true
        override val title = "Home"
    }

    @Serializable
    data object Category : Destination {
        override val isTopLevelDestination = true
        override val title = "Category"
    }

    @Serializable
    data object Favorite : Destination {
        override val isTopLevelDestination = true
        override val title = "Favorites"
    }

    @Serializable
    data object Me : Destination {
        override val isTopLevelDestination = true
        override val title = "Me"
    }

    companion object {
        @Composable
        fun getIcon(destination: Destination) : Painter {
            return when (destination) {
                Home -> painterResource(Resources.Icons.Outlined.Home)
                Category -> painterResource(Resources.Icons.Outlined.Category)
                Favorite -> painterResource(Resources.Icons.Outlined.Heart)
                Me -> painterResource(Resources.Icons.Outlined.Profile)
            }
        }

        fun fromRoute(route: String?) : Destination {
            return when {
                route?.contains("Home") == true -> Home
                route?.contains("Category") == true -> Category
                route?.contains("Favorite") == true -> Favorite
                route?.contains("Me") == true -> Me
                else -> Home
            }
        }

        val drawerDestinations = listOf(
            Home,
            Category,
            Favorite,
            Me
        )
    }

}