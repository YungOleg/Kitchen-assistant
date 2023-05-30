package com.example.kitchen_assistant.domain.repository

import com.example.kitchen_assistant.domain.local.model.Favourites
import kotlinx.coroutines.flow.Flow

interface FavouritesRepository {
    fun getAllFavourites(): Flow<List<Favourites>>
    suspend fun insertFavourites(favourites: Favourites)
    suspend fun deleteFavourites(favourites: Favourites)
}