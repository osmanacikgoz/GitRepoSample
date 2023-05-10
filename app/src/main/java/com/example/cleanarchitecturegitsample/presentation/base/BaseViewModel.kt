package com.example.cleanarchitecturegitsample.presentation.base

import androidx.lifecycle.ViewModel

open class BaseViewModel :ViewModel(){
    override fun onCleared() {
        super.onCleared()
    }
}