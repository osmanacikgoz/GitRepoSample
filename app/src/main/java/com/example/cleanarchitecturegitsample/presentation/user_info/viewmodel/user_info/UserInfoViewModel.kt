package com.example.cleanarchitecturegitsample.presentation.user_info.viewmodel.user_info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturegitsample.data.remote.Resource
import com.example.cleanarchitecturegitsample.domain.usecase.user_info.GetUserInfoUseCase
import com.example.cleanarchitecturegitsample.presentation.base.BaseViewModel
import kotlinx.coroutines.launch

class UserInfoViewModel(private val getUserInfoUseCase: GetUserInfoUseCase) : BaseViewModel() {

    private val _onUserInfoState by lazy { MutableLiveData<UserInfoState>() }

    val onUserInfoState: LiveData<UserInfoState> = _onUserInfoState

    fun getRepos(loginName: String) {

        viewModelScope.launch {
            getUserInfoUseCase.getUserInfo(loginName).collect() { result ->

                when (result) {
                    is Resource.Success -> _onUserInfoState.value =
                        UserInfoState.Success(result.data)

                    is Resource.Error -> _onUserInfoState.value =
                        UserInfoState.Error(result.errorMessage)
                }
            }
        }
    }
}