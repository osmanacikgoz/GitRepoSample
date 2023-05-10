package com.example.cleanarchitecturegitsample.data.repository.user_info

import com.anthony.net.sample.github.domain.entity.user_info.Commit
import com.example.cleanarchitecturegitsample.data.remote.Resource

interface CommitsRepository {

    suspend fun getCommits(
        userName:String,
        repoName:String
    ):Resource<List<Commit>>
}