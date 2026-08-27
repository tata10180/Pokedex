package com.thays.pokedex

import android.content.Context
import androidx.core.content.edit




class LoginRepository(private val context: Context) {

    private val ADMIN_EMAIL = "admin@gmail.com" //model

    private val ADMIN_PASSWORD = "admin123" //model

    fun login(email: String, password: String): Boolean{
        return email == ADMIN_EMAIL && password == ADMIN_PASSWORD
    }

    fun save(email:String){
        val sharedPreference = context.getSharedPreferences("PokedexApp", Context.MODE_PRIVATE)
            sharedPreference.edit{
            putString("EMAIL", email)
            putBoolean("isLoggedIn", true)
            apply()


        }
    }
}

//o shared preference entra aqui tb?sim