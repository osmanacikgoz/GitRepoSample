package com.example.cleanarchitecturegitsample.presentation.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturegitsample.data.remote.Resource
import com.example.cleanarchitecturegitsample.domain.usecase.login.GetLoginUseCase
import com.example.cleanarchitecturegitsample.presentation.base.BaseViewModel
import kotlinx.coroutines.launch

class LoginViewModel(private val getLoginUseCase: GetLoginUseCase) : BaseViewModel() {

    private val _onLoginState by lazy { MutableLiveData<LoginState>() }

    val onLoginState: LiveData<LoginState> = _onLoginState


    fun getUser(userName: String) {
        viewModelScope.launch {
            getLoginUseCase.getUser(userName).collect { result ->

                when (result) {
                    is Resource.Success -> _onLoginState.value = LoginState.Success(result.data)

                    is Resource.Error -> _onLoginState.value = LoginState.Error(result.errorMessage)
                }
            }
        }
    }
}