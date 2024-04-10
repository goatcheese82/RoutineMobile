package com.example.routine.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.routine.api.MyApiService
import com.example.routine.api.Task
import com.example.routine.api.Event // Import the Event class
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TaskViewModel(private val apiService: MyApiService) : ViewModel() {

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks = _tasks.asStateFlow()

    private val _events = MutableStateFlow<Map<Int, Event>>(emptyMap()) // Maintain state for events
    val events = _events.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val fetchedTasks = apiService.getTasks()
                _tasks.value = fetchedTasks

                // Fetch events
                val fetchedEvents = apiService.getEvents()
                _events.value = fetchedEvents.associateBy { it.id } // Map events by their ID

            } catch (e: Exception) {
                // Handle network errors
            }
        }
    }
}
