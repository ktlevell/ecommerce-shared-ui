/**
 * Lazy code base not recommend use in real projects
 */
package com.ktlevell.ecommercesharedui.ecommercesharedui.navigation

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ktlevell.ecommercesharedui.navigation.Destination
import com.ktlevell.ecommercesharedui.navigation.NavDrawer
import com.ktlevell.ecommercesharedui.navigation.Navigator
import com.ktlevell.ecommercesharedui.navigation.NavigatorImpl
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

    NavDrawer(
        drawerState = drawerState,
        currentDestination = currentDestination,
        onDestinationClicked = { destination ->
            navigator.navigate(destination)
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Destination.Home
        ) {

        }
    }

}