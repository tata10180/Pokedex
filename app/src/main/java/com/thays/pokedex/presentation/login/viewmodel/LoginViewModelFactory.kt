package com.thays.pokedex.presentation.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.thays.pokedex.domain.repository.LoginRepository


class LoginViewModelFactory(private val repository: LoginRepository): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun<T: ViewModel> create(modelClass: Class<T>): T{
        return LoginViewModel(repository) as T
    }
}