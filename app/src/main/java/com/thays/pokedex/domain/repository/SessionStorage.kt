package com.thays.pokedex.domain.repository

interface SessionStorage {
    fun saveSession(email:String)
}