package com.example.cleanarchitecturegitsample.presentation.user_info.viewmodel.commit

import com.anthony.net.sample.github.domain.entity.user_info.Commit


sealed class CommitState {
    data class Success(val commits: List<Commit>?) : CommitState()
    data class Error(val errorMessage: String?) : CommitState()
}