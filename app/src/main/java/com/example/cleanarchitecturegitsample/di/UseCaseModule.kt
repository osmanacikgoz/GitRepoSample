package com.example.cleanarchitecturegitsample.di

import com.example.cleanarchitecturegitsample.domain.usecase.login.GetLoginUseCase
import com.example.cleanarchitecturegitsample.domain.usecase.user_info.GetCollaboratorsUseCase
import com.example.cleanarchitecturegitsample.domain.usecase.user_info.GetCommitsUseCase
import com.example.cleanarchitecturegitsample.domain.usecase.user_info.GetUserInfoUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetLoginUseCase(get()) }
    single { GetUserInfoUseCase(get()) }
    single { GetCommitsUseCase(get()) }
    single { GetCollaboratorsUseCase(get()) }
}