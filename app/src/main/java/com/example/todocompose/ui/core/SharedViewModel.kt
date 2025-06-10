package com.example.todocompose.ui.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todocompose.data.models.TodoTask
import com.example.todocompose.data.presistance.database.TodoRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class SharedViewModel @Inject constructor(private val todoRepo: TodoRepo) : ViewModel() {

    // PUBLIC and IMMUTABLE: The outside world can read this, but cannot change its value.
    val allTasks: StateFlow<List<TodoTask>> = todoRepo.getAllTasks
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )


}