package com.example.cleanarchitecturegitsample.data.repository.user_info

import com.anthony.net.sample.github.domain.entity.user_info.Collaborator
import com.example.cleanarchitecturegitsample.data.remote.Resource

interface CollaboratorsRepository {

    suspend fun getCollaborators(
        owner: String,
        repo: String
    ): Resource<List<Collaborator>>
}