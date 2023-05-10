package com.example.cleanarchitecturegitsample.domain.usecase.login

import com.example.cleanarchitecturegitsample.data.remote.Resource
import com.example.cleanarchitecturegitsample.data.repository.login.LoginRepository
import com.example.cleanarchitecturegitsample.domain.entity.common.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetLoginUseCase(private val loginRepository: LoginRepository) {
    suspend fun getUser(userName: String): Flow<Resource<User>> = flow {
        val result = loginRepository.getUser(userName)
        emit(result)
    }.flowOn(Dispatchers.IO)
}