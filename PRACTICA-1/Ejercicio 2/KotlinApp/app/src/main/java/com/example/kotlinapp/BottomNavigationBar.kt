package com.example.kotlinapp

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        Screen.TextFields,
        Screen.Buttons,
        Screen.Selection,
        Screen.Lists,
        Screen.Information
    )

    NavigationBar(containerColor = Color(217, 106, 199)) {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route

        items.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(painterResource(screen.icon), contentDescription = null) },
                label = { Text(stringResource(screen.title)) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    selectedTextColor = Color.Black,
                    indicatorColor = Color.Transparent,
                ),
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
}

sealed class Screen(val route: String, val title: Int, val icon: Int) {
    object TextFields : Screen("textfields", R.string.textfields_title, R.drawable.ic_text_field)
    object Buttons : Screen("buttons", R.string.buttons_title, R.drawable.ic_button)
    object Selection : Screen("selection", R.string.selection_title, R.drawable.ic_selection)
    object Lists : Screen("lists", R.string.lists_title, R.drawable.ic_list)
    object Information : Screen("information", R.string.information_title, R.drawable.ic_info)
}