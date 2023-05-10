package com.example.cleanarchitecturegitsample.domain.entity.login

import kotlinx.serialization.Serializable

@Serializable
data class Repository(
    val id: Int,
    val avatarUrl: String,
    val stargazersCount: Int,
    val forksCount: Int,
    val repositoryOwner: String,
    val repositoryName: String,
    val repositoryDescription: String,
    val repositoryLanguage: String,
) : java.io.Serializable