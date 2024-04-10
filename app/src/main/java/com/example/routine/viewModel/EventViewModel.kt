package com.example.routine.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.routine.api.Event
import com.example.routine.api.MyApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EventViewModel(private val apiService: MyApiService) : ViewModel() {

    private val _events = MutableStateFlow<List<Event>>(emptyList())
    val events = _events.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val fetchedEvents = apiService.getEvents()
                _events.value = fetchedEvents
            } catch (e: Exception) {
                // Handle network errors
            }
        }
    }
}