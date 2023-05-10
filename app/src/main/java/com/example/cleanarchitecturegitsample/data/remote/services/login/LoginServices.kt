package com.example.cleanarchitecturegitsample.data.remote.services.login

import com.anthony.net.sample.github.data.remote.dto.common.UserDto
import retrofit2.http.GET
import retrofit2.http.Path

interface LoginServices {

    @GET("user/{userName}")
    suspend fun getUser(
        @Path("userName") userName:String
    ):UserDto
}