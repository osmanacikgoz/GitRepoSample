package com.example.cleanarchitecturegitsample.di

import com.example.cleanarchitecturegitsample.data.repository.login.LoginRepository
import com.example.cleanarchitecturegitsample.data.repository.login.LoginRepositoryImpl
import com.example.cleanarchitecturegitsample.data.repository.user_info.*
import org.koin.dsl.module

val repositoryModule = module {
    single<LoginRepository> { LoginRepositoryImpl(get()) }
    single<CommitsRepository> { CommitsRepositoryImpl(get()) }
    single<CollaboratorsRepository> { CollaboratorsRepositoryImpl(get()) }
    single<UserInfoRepository> { UserInfoRepositoryImpl(get()) }
}