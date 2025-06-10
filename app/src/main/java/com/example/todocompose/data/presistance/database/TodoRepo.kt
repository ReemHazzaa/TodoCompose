package com.example.todocompose.data.presistance.database

import com.example.todocompose.data.models.Priority
import com.example.todocompose.data.models.TodoTask
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class TodoRepo @Inject constructor(
    private val todoDao: TodoDao
) {
    val getAllTasks = todoDao.getAllTasks()

    fun getSelectedTask(taskId: Int) = todoDao.getSelectedTask(taskId)

    suspend fun addTask(todoTask: TodoTask) = todoDao.addTask(todoTask)

    suspend fun updateTask(taskId: Int, title: String, description: String, priority: Priority) =
        todoDao.updateTask(taskId, title, description, priority)

    suspend fun deleteTask(todoTask: TodoTask) = todoDao.deleteTask(todoTask)

    suspend fun deleteAllTasks() = todoDao.deleteAllTasks()

    fun searchDatabase(searchQuery: String) = todoDao.searchDatabase(searchQuery)

    fun sortByLowPriority() = todoDao.sortByLowPriority()

    fun sortByHighPriority() = todoDao.sortByHighPriority()
}