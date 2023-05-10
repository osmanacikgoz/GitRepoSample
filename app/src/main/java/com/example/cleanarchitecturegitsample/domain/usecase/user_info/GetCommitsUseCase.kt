package com.example.cleanarchitecturegitsample.domain.usecase.user_info

import com.anthony.net.sample.github.domain.entity.user_info.Commit
import com.example.cleanarchitecturegitsample.data.remote.Resource
import com.example.cleanarchitecturegitsample.data.repository.user_info.CommitsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetCommitsUseCase(private val commitsRepository: CommitsRepository) {

    suspend fun getCommits(
        userName:String,repoName:String
    ):Flow<Resource<List<Commit>>> = flow {
        val result = commitsRepository.getCommits(userName, repoName)
        emit(result)
    }.flowOn(Dispatchers.IO)
}