package com.example.cleanarchitecturegitsample.data.remote.services.user_info

import com.anthony.net.sample.github.data.remote.dto.user_info.CommitDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CommitServices {

    @GET("repos/{owner}/{repo}/commits")
    suspend fun getCommits(
        @Path("owner") owner:String,
        @Path("repo") repo :String
    ):List<CommitDto>
}