package com.example.kitchen_assistant.presentation.ui.screens.recipe_detail.viewmodel

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kitchen_assistant.domain.local.model.Favourites
import com.example.kitchen_assistant.domain.local.usecase.FavouritesUseCases
import com.example.kitchen_assistant.presentation.ui.screens.recipes.viewmodel.RecipeListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val favouritesUseCases: FavouritesUseCases
): ViewModel() {

    private val _state = mutableStateOf(RecipeDetailScreenState())
    val state: State<RecipeDetailScreenState> = _state

    fun insertFavourite(favourites: Favourites) {
        viewModelScope.launch {
            favouritesUseCases.insertFavouritesUseCase.invoke(favourites)
        }
        Log.i("[INFO]", "is insert")
    }

    fun deleteFavourite(favourites: Favourites) {
        viewModelScope.launch {
            favouritesUseCases.deleteFavouritesUseCase.invoke(favourites)
        }
        Log.i("[INFO]", "is delete")
    }
}

data class RecipeDetailScreenState(
    var isDelete: Boolean = true
)