package com.thays.pokedex

import androidx.lifecycle.ViewModel

class LoginViewModel(private val repository: LoginRepository): ViewModel() {

    private lateinit var loginRepository: LoginRepository
    fun login(email:String, password: String): Boolean{

        if(email.isNotEmpty()&&password.isNotEmpty()) {
            if(repository.login(email, password)){
                repository.save(email)
                return true
            }

        }
        return false//
    }
}