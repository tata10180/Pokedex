package com.thays.pokedex.di

import android.content.Context
import android.content.SharedPreferences
import com.thays.pokedex.data.local.SessionStorageImpl
import com.thays.pokedex.data.network.PokemonApiService
import com.thays.pokedex.data.network.RetrofitClient
import com.thays.pokedex.data.repository.ListRepositoryImpl
import com.thays.pokedex.data.repository.LoginRepositoryImpl
import com.thays.pokedex.domain.repository.ListRepository
import com.thays.pokedex.domain.repository.LoginRepository
import com.thays.pokedex.domain.repository.SessionStorage

class AppContainer(context: Context) {

    private val pokemonApi: PokemonApiService by lazy{
        RetrofitClient.retrofit.create(PokemonApiService::class.java)
    }

    val loginRepository: LoginRepository by lazy {
        LoginRepositoryImpl(context) //adicionar by lazy talvez
    }
    val listRepository: ListRepository by lazy {
        ListRepositoryImpl(pokemonApi)
    }
    private val prefs: SharedPreferences =
        context.getSharedPreferences("session", Context.MODE_PRIVATE)

    // Exposto com o tipo da interface (Domain)
    val sessionStorage: SessionStorage = SessionStorageImpl(prefs)

}