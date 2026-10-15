package com.thays.pokedex.login.viewmodel

import androidx.lifecycle.ViewModel
import com.thays.pokedex.login.model.LoginRepository

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