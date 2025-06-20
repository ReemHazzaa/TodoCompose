package com.example.todocompose.ui.naviagtion

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.todocompose.ui.naviagtion.destinations.listComposable
import com.example.todocompose.ui.naviagtion.destinations.taskComposable
import com.example.todocompose.util.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(
    navHostController: NavHostController
) {
    val screen = remember(navHostController) {
        Screens(navHostController = navHostController)
    }

    NavHost(
        navController = navHostController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(
            navigateToTaskScreen = screen.task
        )
        taskComposable (
            navigateToListScreen = screen.list
        )
    }

}