package com.example.cleanarchitecturegitsample.presentation.user_info.viewmodel.collaborators

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturegitsample.data.remote.Resource
import com.example.cleanarchitecturegitsample.domain.usecase.user_info.GetCollaboratorsUseCase
import com.example.cleanarchitecturegitsample.presentation.base.BaseViewModel
import kotlinx.coroutines.launch

class CollaboratorsViewModel(private val getCollaboratorsUseCae: GetCollaboratorsUseCase) :
    BaseViewModel() {

    private val _onCollaboratorsState by lazy { MutableLiveData<CollaboratorsState>() }
    val onCollaboratorsState: LiveData<CollaboratorsState> = _onCollaboratorsState

    fun getCollaborators(userName: String, repoName: String) {

        viewModelScope.launch {
            getCollaboratorsUseCae.getCollaborators(userName, repoName).collect { result ->

                when (result) {
                    is Resource.Success -> _onCollaboratorsState.value =
                        CollaboratorsState.Success(result.data)

                    is Resource.Error -> _onCollaboratorsState.value =
                        CollaboratorsState.Error(result.errorMessage)
                }
            }
        }
    }
}