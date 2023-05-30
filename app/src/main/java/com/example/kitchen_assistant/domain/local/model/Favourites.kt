package com.example.kitchen_assistant.domain.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kitchen_assistant.util.constants.Constants

@Entity(tableName = Constants.DATABASE_NAME)
data class Favourites(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val instructions: String,
    val imageUrl: String,
    val ingredients: String,
    val rating: Int
)
