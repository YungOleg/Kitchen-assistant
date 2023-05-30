package com.example.kitchen_assistant.presentation.ui.components

import com.example.kitchen_assistant.R

sealed class Screen(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Recipes : Screen(
        route = "recipes_screen",
        title = "Recipes",
        icon = R.drawable.list
    )

    object Favourites : Screen(
        route = "favourites_screen",
        title = "Favourites",
        icon = R.drawable.favorite
    )

    companion object {
        const val RECIPE_DETAIL_ROUTE = "recipe_detail"
        const val FAVOURITES_DETAIL_ROUTE = "favourites_detail"
    }
}