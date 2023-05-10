package com.example.cleanarchitecturegitsample.domain.usecase.user_info

import com.example.cleanarchitecturegitsample.data.remote.Resource
import com.example.cleanarchitecturegitsample.data.repository.user_info.UserInfoRepository
import com.example.cleanarchitecturegitsample.domain.entity.login.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetUserInfoUseCase(private val userInfoRepository: UserInfoRepository) {
    suspend fun getUserInfo(loginName:String):Flow<Resource<List<Repository>>> = flow {
        val result = userInfoRepository.getRepositories(loginName)
        emit(result)
    }.flowOn(Dispatchers.IO)
}