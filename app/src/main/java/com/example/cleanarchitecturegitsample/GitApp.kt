package com.example.cleanarchitecturegitsample

import android.content.Context
import androidx.multidex.MultiDexApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GitApp:MultiDexApplication() {

    companion object {
        lateinit var context:GitApp
        private set
    }

    override fun onCreate() {
        super.onCreate()
        context = this

        startKoin {
            androidContext(this@GitApp)
            modules(listOf())
        }
    }
}