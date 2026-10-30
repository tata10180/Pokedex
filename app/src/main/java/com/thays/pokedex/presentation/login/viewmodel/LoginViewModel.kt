package com.thays.pokedex.presentation.login.viewmodel

import androidx.lifecycle.ViewModel
import com.thays.pokedex.domain.repository.LoginRepository

class LoginViewModel(private val repository: LoginRepository) : ViewModel() {

    fun login(email: String, password: String): Boolean {

        if (email.isNotEmpty() && password.isNotEmpty()) {
            if (repository.login(email, password)) {
               // repository.save(email)
                return true
            }

        }
        return false
    }
}