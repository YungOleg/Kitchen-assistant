package com.example.kitchen_assistant.data.local.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kitchen_assistant.domain.local.model.Favourites

@Database(
    entities = [Favourites::class],
    version = 1,
    exportSchema = false
)
abstract class FavouritesDatabase: RoomDatabase() {

    abstract fun getFavouritesDao(): FavouritesDao

}