package com.example.kitchen_assistant.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.kitchen_assistant.R

val poppins_light = FontFamily(
    Font(R.font.poppins_light, FontWeight.Light)
)

val poppins_bold = FontFamily(
    Font(R.font.poppins_bold, FontWeight.Light)
)

val poppins_regular = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Light)
)

val Typography = Typography(
    headlineLarge = TextStyle (
        fontFamily = poppins_bold,
        fontSize = 20.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = poppins_regular,
        fontSize = 16.sp
    ),
    bodySmall = TextStyle(
        fontFamily = poppins_light,
        fontSize = 16.sp
    ),
    titleMedium = TextStyle(
        fontFamily = poppins_light,
        fontSize = 12.sp
    ),
    titleSmall = TextStyle(
        fontFamily = poppins_light,
        fontSize = 8.sp
    )
)