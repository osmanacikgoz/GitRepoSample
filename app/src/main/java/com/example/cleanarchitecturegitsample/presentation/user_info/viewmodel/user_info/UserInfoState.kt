package com.example.cleanarchitecturegitsample.presentation.user_info.viewmodel.user_info

import com.example.cleanarchitecturegitsample.domain.entity.login.Repository

sealed class UserInfoState {
    data class Success(val repository: List<Repository>?) : UserInfoState()
    data class Error(val errorMessage: String?) : UserInfoState()
}