package com.example.hw3

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProViewModelFactory (
    private  val dataSource : ContentDAO,
    private  val application: Application):ViewModelProvider.Factory{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(ProViewModel::class.java)) {
                return ProViewModel(dataSource,application) as T
            }
            throw IllegalAccessException("Unknown class")
    }
}