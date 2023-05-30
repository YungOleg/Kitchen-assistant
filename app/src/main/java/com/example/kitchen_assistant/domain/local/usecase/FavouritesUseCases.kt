package com.example.kitchen_assistant.domain.local.usecase

data class FavouritesUseCases(
    val insertFavouritesUseCase: InsertFavouritesUseCase,
    val getFavouritesUseCase: GetFavouritesUseCase,
    val deleteFavouritesUseCase: DeleteFavouritesUseCase
)