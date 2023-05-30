package com.example.kitchen_assistant.data.recipes.repository

import com.example.kitchen_assistant.data.recipes.local.source.FavouritesDao
import com.example.kitchen_assistant.domain.local.model.Favourites
import com.example.kitchen_assistant.domain.repository.FavouritesRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class FavouritesRepositoryImpl @Inject constructor(
    private val dao: FavouritesDao
): FavouritesRepository {
    override fun getAllFavourites(): Flow<List<Favourites>> = dao.getAllFavourites()
    override suspend fun insertFavourites(favourites: Favourites) = dao.insertFavourite(favourites)
    override suspend fun deleteFavourites(favourites: Favourites) = dao.deleteFavourite(favourites)
}