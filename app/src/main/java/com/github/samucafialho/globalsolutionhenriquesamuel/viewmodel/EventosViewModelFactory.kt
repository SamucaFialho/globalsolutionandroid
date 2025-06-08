package com.github.samucafialho.globalsolutionhenriquesamuel.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class EventosViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EventosExtremosViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EventosExtremosViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}