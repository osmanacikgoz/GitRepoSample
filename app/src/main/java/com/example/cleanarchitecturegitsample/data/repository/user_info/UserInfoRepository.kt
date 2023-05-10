package com.example.cleanarchitecturegitsample.data.repository.user_info

import com.example.cleanarchitecturegitsample.data.remote.Resource
import com.example.cleanarchitecturegitsample.domain.entity.login.Repository

interface UserInfoRepository {

    suspend fun getRepositories(
        loginName: String
    ): Resource<List<Repository>>
}