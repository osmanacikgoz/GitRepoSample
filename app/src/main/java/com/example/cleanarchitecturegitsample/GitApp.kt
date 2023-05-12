package com.example.cleanarchitecturegitsample

import androidx.multidex.MultiDexApplication
import com.example.cleanarchitecturegitsample.di.repositoryModule
import com.example.cleanarchitecturegitsample.di.servicesModule
import com.example.cleanarchitecturegitsample.di.useCaseModule
import com.example.cleanarchitecturegitsample.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GitApp : MultiDexApplication() {

    companion object {
        lateinit var context: GitApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = this

        startKoin {
            androidContext(this@GitApp)
            modules(listOf(useCaseModule, repositoryModule, viewModelModule, servicesModule))
        }
    }
}