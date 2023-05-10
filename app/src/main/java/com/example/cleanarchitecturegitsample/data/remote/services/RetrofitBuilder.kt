package com.example.cleanarchitecturegitsample.data.remote.services

import com.example.cleanarchitecturegitsample.BuildConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import okio.IOException
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

object RetrofitBuilder {


    val json = Json {
        isLenient = true
        ignoreUnknownKeys = true
    }


    fun createOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        val httpLoggingInterceptor = HttpLoggingInterceptor()

        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClient
            .retryOnConnectionFailure(true)
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .followRedirects(false)
            .followSslRedirects(false)
            .addInterceptor(httpLoggingInterceptor)

        httpClient.addInterceptor(RedirectInterceptor())

        return httpClient.build()

    }

    inline fun <reified T> createServices(): T {
        val contentType = "application/json".toMediaType()
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(createOkHttpClient())
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()

        return retrofit.create(T::class.java)
    }

    private fun createResponse(chain: Interceptor.Chain, request: Request): Response {
        return chain.proceed(
            request.newBuilder()
                .header("Accept", "application/vnd.github+json")
                .header("X-GitHub-Api-Version", "2022-11-28")
                .method(request.method, request.body).build()
        )
    }

    class RedirectInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            return createResponse(chain, request)
        }
    }
}