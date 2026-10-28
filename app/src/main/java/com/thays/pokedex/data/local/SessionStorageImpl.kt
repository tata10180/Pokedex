package com.thays.pokedex.data.local

import android.content.Context
import androidx.core.content.edit
import com.thays.pokedex.domain.repository.SessionStorage

class SessionStorageImpl (private val context: Context
) : SessionStorage {
    override fun saveSession(email: String) { //isso sai do domain?
        val prefs = context.getSharedPreferences("PokedexApp", Context.MODE_PRIVATE)
        prefs.edit {
            putString("EMAIL", email)
            putBoolean("isLoggedIn", true)



        }
    }
}