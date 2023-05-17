package com.example.cleanarchitecturegitsample.data.remote.services.user_info

import com.example.cleanarchitecturegitsample.data.remote.dto.user_info.CollaboratorDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CollaboratorsServices {

    @GET("repos/{owner}/{repo}/collaborators")
    suspend fun getCollaborators(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): List<CollaboratorDto>
}