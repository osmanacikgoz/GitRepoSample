package com.example.cleanarchitecturegitsample.data.remote

import com.example.cleanarchitecturegitsample.data.remote.services.RetrofitBuilder
import kotlinx.serialization.decodeFromString
import okio.IOException
import retrofit2.HttpException


sealed class Resource<out T> {

    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val errorMessage: String) : Resource<Nothing>()
}


fun <T> handleException(e: Exception): Resource<T> {
    return when (e) {
        is HttpException -> {
            val errorMessage = e.response()?.errorBody()?.let {
                RetrofitBuilder.json.decodeFromString<com.anthony.net.sample.github.data.remote.dto.common.Error>(
                    it.string()
                ).message
            } ?: ""
            Resource.Error(errorMessage)
        }
        is IOException -> {
            Resource.Error("")
        }
        else -> {
            Resource.Error("")
        }
    }
}