package com.example.cleanarchitecturegitsample.data.remote.services.user_info

import com.anthony.net.sample.github.data.remote.dto.login.RepositoryDto
import retrofit2.http.GET
import retrofit2.http.Path

interface UserInfoServices {

    @GET("users/{userName}/repos")
    suspend fun getRepositories(
        @Path("userName") userName: String
    ): List<RepositoryDto>
}