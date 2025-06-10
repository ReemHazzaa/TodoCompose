package com.example.todocompose.data.presistance.database

import androidx.compose.ui.graphics.Color
import androidx.room.TypeConverter
import com.example.todocompose.data.models.Priority
import com.example.todocompose.ui.theme.HighPriorityColor
import com.example.todocompose.ui.theme.LowPriorityColor
import com.example.todocompose.ui.theme.MediumPriorityColor
import com.example.todocompose.ui.theme.NonePriorityColor

class DatabaseConverters {

    @TypeConverter
    fun fromPriorityToColor(priority: Priority): Color {
        return when (priority) {
            Priority.High -> HighPriorityColor
            Priority.Medium -> MediumPriorityColor
            Priority.Low -> LowPriorityColor
            Priority.None -> NonePriorityColor
        }
    }

    @TypeConverter
    fun fromColorToPriority(color: Color): Priority {
        return when (color) {
            HighPriorityColor -> Priority.High
            MediumPriorityColor -> Priority.Medium
            LowPriorityColor -> Priority.Low
            else -> Priority.None
        }
    }

}