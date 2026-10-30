package com.thays.pokedex.domain.repository


interface LoginRepository { // eu posso trocar para interface? pode


    fun login(email: String, password: String): Boolean

   // fun save(email: String)


}