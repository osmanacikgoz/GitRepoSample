package com.example.cleanarchitecturegitsample.presentation.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.cleanarchitecturegitsample.custom.CustomDialog

open class BaseFragment:Fragment() {

    private lateinit var customLoadingDialog:CustomDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    fun showLoadingDialog() {
        customLoadingDialog.start("Loading")
    }

    fun dismissLoadingDialog() {
        customLoadingDialog.stop()
    }
}