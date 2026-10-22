package com.thays.pokedex.data.repository

import android.content.Context
import androidx.core.content.edit
import com.thays.pokedex.domain.repository.LoginRepository

class LoginRepositoryImpl(private val context: Context): LoginRepository {

    private val ADMIN_EMAIL = "admin@gmail.com" //fica aqui por estar hardcoded

    private val ADMIN_PASSWORD = "admin123" //fica aqui por estar hardcoded

    override fun login(email: String, password: String): Boolean {
        return email == ADMIN_EMAIL && password == ADMIN_PASSWORD

    }


    override fun save(email: String) { //isso sai do domain?
        val sharedPreference = context.getSharedPreferences("PokedexApp", Context.MODE_PRIVATE)
        sharedPreference.edit {
            putString("EMAIL", email)
            putBoolean("isLoggedIn", true)
            apply()


        }
    }
}