package com.example.cleanarchitecturegitsample.data.repository.login

import com.example.cleanarchitecturegitsample.data.remote.Resource
import com.example.cleanarchitecturegitsample.data.remote.handleException
import com.example.cleanarchitecturegitsample.data.remote.services.login.LoginServices
import com.example.cleanarchitecturegitsample.domain.entity.common.User

class LoginRepositoryImpl(private val loginServices: LoginServices): LoginRepository {
    override suspend fun getUser(userName: String): Resource<User> {
        return try {
            val originData = loginServices.getUser(userName)

            val dataMapping = User(originData.login)
            Resource.Success(dataMapping)
        }catch (e:Exception) {
            handleException(e)
        }
    }
}