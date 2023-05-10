package com.anthony.net.sample.github.data.remote.dto.common

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val avatar_url: String,
    val bio: String? = null,
    val blog: String,
    val company: String? = null,
    val created_at: String,
    val email: String? = null,
    val events_url: String,
    val followers: Int,
    val followers_url: String,
    val following: Int,
    val following_url: String,
    val gists_url: String,
    val gravatar_id: String,
    val hireable: Boolean?=null,
    val html_url: String,
    val id: Int,
    val location: String?=null,
    val login: String,
    val name: String?=null,
    val node_id: String,
    val organizations_url: String,
    val public_gists: Int,
    val public_repos: Int,
    val received_events_url: String,
    val repos_url: String,
    val site_admin: Boolean,
    val starred_url: String,
    val subscriptions_url: String,
    val twitter_username: String?=null,
    val type: String,
    val updated_at: String,
    val url: String
): java.io.Serializable
