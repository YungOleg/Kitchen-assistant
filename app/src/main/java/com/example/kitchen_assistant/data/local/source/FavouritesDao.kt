package com.example.kitchen_assistant.data.local.source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kitchen_assistant.domain.local.model.Favourites
import com.example.kitchen_assistant.util.constants.Constants
import kotlinx.coroutines.flow.Flow


@Dao
interface FavouritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavourite(favourites: Favourites)

    @Delete
    suspend fun deleteFavourite(favourites: Favourites)

    // ORDER BY isFavourite
    @Query("SELECT * FROM ${Constants.DATABASE_NAME}")
    fun getAllFavourites(): Flow<List<Favourites>>
}