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
    
    /**
     * Exposes the list of all tasks as a read-only StateFlow for the UI to observe.
     *
     * This declarative approach uses `stateIn` to convert the "cold" Flow from the repository
     * into a "hot" StateFlow. It effectively replaces the traditional `private _flow / public flow`
     * pattern while maintaining strong data hiding principles:
     *
     * 1.  **The Public API is Immutable:** The UI is exposed to a `StateFlow`, not a
     * `MutableStateFlow`, so it cannot directly set or change the state.
     *
     * 2.  **Mutation is Controlled Internally:** State changes are driven solely by new emissions
     * from the upstream `todoRepo.getAllTasks` flow. The ViewModel transforms this data stream
     * into a UI state stream without exposing any mutable components.
     *
     * 3.  **Lifecycle-Aware & Efficient:** The `SharingStarted.WhileSubscribed` strategy ensures
     * the upstream flow from the repository is only active when the UI is actually observing
     * the data, which saves system resources.
     */
    val allTasks: StateFlow<List<TodoTask>> = todoRepo.getAllTasks
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )


}