package com.thays.pokedex.di

import android.app.Application

class PokemonApplication: Application() {
    lateinit var container: AppContainer
    private set

    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
    }
}