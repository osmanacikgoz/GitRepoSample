package com.example.cleanarchitecturegitsample.presentation.login.viewmodel

import com.example.cleanarchitecturegitsample.domain.entity.common.User

sealed class LoginState {
    data class Success(val user: User?) : LoginState()
    data class Error(val errorMessage: String?) : LoginState()
}