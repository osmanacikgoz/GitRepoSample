package com.example.cleanarchitecturegitsample.di

import com.example.cleanarchitecturegitsample.presentation.login.viewmodel.LoginViewModel
import com.example.cleanarchitecturegitsample.presentation.user_info.viewmodel.collaborators.CollaboratorsViewModel
import com.example.cleanarchitecturegitsample.presentation.user_info.viewmodel.commit.CommitViewModel
import com.example.cleanarchitecturegitsample.presentation.user_info.viewmodel.user_info.UserInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { CollaboratorsViewModel(get()) }
    viewModel { UserInfoViewModel(get()) }
    viewModel { CommitViewModel(get()) }
}