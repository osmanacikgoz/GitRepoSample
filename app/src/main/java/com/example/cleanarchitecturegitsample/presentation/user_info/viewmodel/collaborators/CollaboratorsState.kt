package com.example.cleanarchitecturegitsample.presentation.user_info.viewmodel.collaborators

import com.anthony.net.sample.github.domain.entity.user_info.Collaborator

sealed class CollaboratorsState {
    data class Success(val collaborators: List<Collaborator>) : CollaboratorsState()
    data class Error(val errorMessage: String?) : CollaboratorsState()
}