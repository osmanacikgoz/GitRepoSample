package com.example.cleanarchitecturegitsample.presentation.user_info.viewmodel.commit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturegitsample.data.remote.Resource
import com.example.cleanarchitecturegitsample.domain.usecase.user_info.GetCommitsUseCase
import com.example.cleanarchitecturegitsample.presentation.base.BaseViewModel
import kotlinx.coroutines.launch

class CommitViewModel(private val getCommitsUseCase: GetCommitsUseCase) : BaseViewModel() {

    private val _onCommitState by lazy { MutableLiveData<CommitState>() }

    val onCommitState: LiveData<CommitState> = _onCommitState

    fun getCommit(userName: String, repoName: String) {
        viewModelScope.launch {
            getCommitsUseCase.getCommits(userName, repoName).collect { result ->
                when (result) {
                    is Resource.Success -> _onCommitState.value = CommitState.Success(result.data)

                    is Resource.Error -> _onCommitState.value =
                        CommitState.Error(result.errorMessage)
                }
            }
        }
    }
}