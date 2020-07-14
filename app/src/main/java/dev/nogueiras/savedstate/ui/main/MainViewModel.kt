package dev.nogueiras.savedstate.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import java.io.Serializable

class MainViewModel(private val state: SavedStateHandle) : ViewModel() {

    private val _data = MutableLiveData<List<String>>()

    val scrollPosition: LiveData<Scroll> = state.getLiveData(CONFIGURATION_KEY)

    val data: LiveData<List<String>> = _data

    init {
        val data = (1..100).map { it.toString() }
        _data.postValue(data)
    }

    fun onSaveInstanceState(configuration: Scroll) {
        state.set(CONFIGURATION_KEY, configuration)
    }

    private companion object {
        const val CONFIGURATION_KEY = "scroll_position"
    }
}

data class Scroll(
    val position: Int
) : Serializable
