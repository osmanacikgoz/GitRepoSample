package com.example.cleanarchitecturegitsample.di

import com.example.cleanarchitecturegitsample.data.remote.services.RetrofitBuilder.createServices
import com.example.cleanarchitecturegitsample.data.remote.services.login.LoginServices
import com.example.cleanarchitecturegitsample.data.remote.services.user_info.CollaboratorsServices
import com.example.cleanarchitecturegitsample.data.remote.services.user_info.CommitServices
import com.example.cleanarchitecturegitsample.data.remote.services.user_info.UserInfoServices
import org.koin.dsl.module

val servicesModule = module {
    single<LoginServices> { createServices() }
    single<CommitServices> { createServices() }
    single<CollaboratorsServices> { createServices() }
    single<UserInfoServices> { createServices() }
}