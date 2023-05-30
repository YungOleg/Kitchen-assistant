package com.example.kitchen_assistant.presentation.ui.screens.favourites.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kitchen_assistant.domain.local.model.Favourites
import com.example.kitchen_assistant.domain.local.usecase.FavouritesUseCases
import com.example.kitchen_assistant.domain.remote.model.Recipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(
    private val favouritesUseCases: FavouritesUseCases
): ViewModel() {

    private val _state = MutableStateFlow(FavouriteState())
    val state: Flow<FavouriteState> = _state

    val favouriteList: Flow<List<Favourites>> = favouritesUseCases.getFavouritesUseCase.invoke()

    fun insertFavourite(favourites: Favourites) {
        viewModelScope.launch {
            favouritesUseCases.insertFavouritesUseCase.invoke(favourites)
        }
    }

    fun deleteFavourite(favourites: Favourites) {
        viewModelScope.launch {
            favouritesUseCases.deleteFavouritesUseCase.invoke(favourites)
        }
    }
}

data class FavouriteState(
    val favourites: List<Favourites> = emptyList(),
)