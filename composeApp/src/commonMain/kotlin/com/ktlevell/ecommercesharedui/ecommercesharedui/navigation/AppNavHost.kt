/**
 * Lazy code base not recommend use in real projects
 */
package com.ktlevell.ecommercesharedui.ecommercesharedui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ktlevell.ecommercesharedui.ecommercesharedui.features.home.HomeRoot
import com.ktlevell.ecommercesharedui.ecommercesharedui.features.home.HomeScreen
import com.ktlevell.ecommercesharedui.navigation.BottomBar
import com.ktlevell.ecommercesharedui.navigation.Category
import com.ktlevell.ecommercesharedui.navigation.Destination
import com.ktlevell.ecommercesharedui.navigation.Favorite
import com.ktlevell.ecommercesharedui.navigation.Home
import com.ktlevell.ecommercesharedui.navigation.Me
import com.ktlevell.ecommercesharedui.navigation.NavDrawer
import com.ktlevell.ecommercesharedui.navigation.Navigator
import com.ktlevell.ecommercesharedui.navigation.NavigatorImpl
import com.ktlevell.ecommercesharedui.theme.AppTheme
import org.koin.mp.KoinPlatform.getKoin

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val currentDestination = Destination.fromRoute(currentRoute)

    LaunchedEffect(currentDestination) {
        if (!currentDestination.isTopLevelDestination) {
            drawerState.close()
        }
    }

    val navigator = getKoin()
        .get<Navigator>() as NavigatorImpl

    SideEffect {
        navigator.attach(navController)
    }

    AppTheme {
        NavDrawer(
            drawerState = drawerState,
            currentDestination = currentDestination,
            onDestinationClicked = { destination ->
                navigator.navigate(destination)
            }
        ) {
            Scaffold(
                modifier = Modifier
                    .navigationBarsPadding(),
                bottomBar = {
                    BottomBar(
                        currentDestination = currentDestination,
                        onDestinationClicked = { destination ->
                            navigator.navigate(destination)
                        }
                    )
                },
                contentWindowInsets = WindowInsets(0, 0, 0, 0)
            ) { paddingValues ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .consumeWindowInsets(paddingValues)
                ) {}
                NavHost(
                    navController = navController,
                    startDestination = Home,
                    modifier = Modifier.padding(paddingValues)
                ) {
                    composable<Home> {
                        HomeRoot()
                    }
                    composable<Category> {

                    }
                    composable<Favorite> {

                    }
                    composable<Me> {

                    }
                }
            }
        }
    }

}