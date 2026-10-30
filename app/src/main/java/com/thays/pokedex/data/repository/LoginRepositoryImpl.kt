package com.thays.pokedex.data.repository

import com.thays.pokedex.domain.repository.LoginRepository
import com.thays.pokedex.domain.repository.SessionStorage

class LoginRepositoryImpl(private val session: SessionStorage) : LoginRepository {

    private val ADMIN_EMAIL = "admin@gmail.com" //fica aqui por estar hardcoded

    private val ADMIN_PASSWORD = "admin123" //fica aqui por estar hardcoded

    override fun login(email: String, password: String): Boolean {
        val success =  email == ADMIN_EMAIL && password == ADMIN_PASSWORD
        if(success){
           session.saveSession(email)
        }
        return success

    }

}
