package com.example.kitchen_assistant.di.modules

import android.content.Context
import androidx.room.Room
import com.example.kitchen_assistant.data.recipes.local.source.FavouritesDatabase
import com.example.kitchen_assistant.util.constants.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun providesRecipeDatabase(@ApplicationContext app: Context) = Room.databaseBuilder(
        app,
        FavouritesDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun providesRecipeDao(db: FavouritesDatabase) = db.getFavouritesDao()
}