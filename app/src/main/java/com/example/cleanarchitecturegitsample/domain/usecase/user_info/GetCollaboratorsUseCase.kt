package com.example.cleanarchitecturegitsample.domain.usecase.user_info

import com.anthony.net.sample.github.domain.entity.user_info.Collaborator
import com.example.cleanarchitecturegitsample.data.remote.Resource
import com.example.cleanarchitecturegitsample.data.repository.user_info.CollaboratorsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetCollaboratorsUseCase(private val collaboratorsRepository: CollaboratorsRepository) {
    suspend fun getCollaborators(
        owner: String, repo: String
    ): Flow<Resource<List<Collaborator>>> = flow {
        val result = collaboratorsRepository.getCollaborators(owner, repo)
        emit(result)
    }.flowOn(Dispatchers.IO)
}