package com.example.kitchen_assistant.domain.local.usecase

import com.example.kitchen_assistant.domain.repository.FavouritesRepository


class GetFavouritesUseCase(
    private val repository: FavouritesRepository
) {
    fun invoke() = repository.getAllFavourites()
}