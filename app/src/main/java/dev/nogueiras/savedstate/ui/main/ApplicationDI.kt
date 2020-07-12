package dev.nogueiras.savedstate.ui.main

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner

object ApplicationDI {
    @Suppress("UNCHECKED_CAST")
    fun provideMainViewModelFromFactory(owner: SavedStateRegistryOwner) =
        object : AbstractSavedStateViewModelFactory(owner, null) {
            override fun <T : ViewModel?> create(
                key: String,
                modelClass: Class<T>,
                handle: SavedStateHandle
            ) = MainViewModel(handle) as T
        }

}
