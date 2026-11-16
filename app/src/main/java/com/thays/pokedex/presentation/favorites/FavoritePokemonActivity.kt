package com.thays.pokedex.presentation.favorites

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.activity.ComponentActivity


class FavoritePokemonActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Text("Favoritos")
        }
    }

}