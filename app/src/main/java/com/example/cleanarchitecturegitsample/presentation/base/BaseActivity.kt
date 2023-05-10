package com.example.cleanarchitecturegitsample.presentation.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitecturegitsample.custom.CustomDialog
import kotlin.math.cos

class BaseActivity:AppCompatActivity() {
    private lateinit var customLoadingDialog:CustomDialog

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)


    }

    fun showLoadingDialog() {
        customLoadingDialog.start("Loading")
    }

    fun dismissLoadingDialog() {
        customLoadingDialog.stop()
    }
}