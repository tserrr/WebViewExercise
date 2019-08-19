package com.tserr.webviewexercise

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val resourceManager: ResourceManager): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return MainViewModel(resourceManager) as T
    }

}