package com.example.todocompose.data.models

import androidx.compose.ui.graphics.Color
import com.example.todocompose.ui.theme.HighPriorityColor
import com.example.todocompose.ui.theme.LowPriorityColor
import com.example.todocompose.ui.theme.MediumPriorityColor
import com.example.todocompose.ui.theme.NonePriorityColor

enum class Priority(color: Color) {
    High(color = HighPriorityColor),
    Medium(color = MediumPriorityColor),
    Low(color = LowPriorityColor),
    None(color = NonePriorityColor)
}