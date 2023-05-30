package com.example.kitchen_assistant.presentation.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.kitchen_assistant.presentation.ui.theme.SecondaryGreen
import com.example.kitchen_assistant.presentation.ui.theme.onSurfaceColor
import com.example.kitchen_assistant.presentation.ui.theme.poppins_light
import com.example.kitchen_assistant.presentation.ui.theme.surfaceColor

@Composable
fun BottomNavigationBar(
    navController: NavHostController
) {
    val screens = listOf(
        Screen.Recipes,
        Screen.Favourites
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        backgroundColor = onSurfaceColor
    ) {
        screens.forEach {
            AddItem(
                screen = it,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: Screen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        selectedContentColor = surfaceColor,
        unselectedContentColor = surfaceColor.copy(alpha = 0.3f),
        label = {
            Text(
                text = screen.title,
                fontFamily = poppins_light,
                fontSize = 12.sp,
                color = surfaceColor
            )
        },
        icon = {
            Icon(
                painter = painterResource(id = screen.icon),
                contentDescription = null
            )
        },
        selected = currentDestination?.hierarchy?.any{
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route){
                popUpTo(screen.route) {
                    inclusive = true
                    saveState = true
                }
            }
        }
    )
}