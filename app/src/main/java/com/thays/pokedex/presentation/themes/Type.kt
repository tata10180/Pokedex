package com.thays.pokedex.presentation.themes

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.thays.pokedex.R


    val PokemonFont = FontFamily(Font(R.font.pokemon_solid))

    val AppTypography = Typography(
        titleLarge = TextStyle(
            fontFamily = PokemonFont,
            fontSize = 45.sp
        ),
        bodyMedium = TextStyle(
          fontFamily = PokemonFont,
            fontSize = 18.sp
        )
    )

