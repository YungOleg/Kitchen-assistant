package com.example.kitchen_assistant.domain.local.usecase

import com.example.kitchen_assistant.domain.local.model.Favourites
import com.example.kitchen_assistant.domain.repository.FavouritesRepository

class DeleteFavouritesUseCase(
    private val repository: FavouritesRepository
) {
    suspend fun invoke(favourites: Favourites) = repository.deleteFavourites(favourites)
}