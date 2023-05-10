package com.example.cleanarchitecturegitsample.data.repository.login

import com.example.cleanarchitecturegitsample.data.remote.Resource
import com.example.cleanarchitecturegitsample.domain.entity.common.User

interface LoginRepository {

    suspend fun getUser(userName:String):Resource<User>
}