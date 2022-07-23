package com.example.fampayproject.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fampayproject.api.handlers.CardGroupSource

class MainActivityViewModelFactory(val app:Application, val cardGroupSource: CardGroupSource) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(app, cardGroupSource) as T
    }
}