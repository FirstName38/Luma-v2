package com.luma.focus.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LumaAdaptiveNavigation(
    currentDestination: String,
    onDestinationSelected: (String) -> Unit,
    isTablet: Boolean,
    content: @Composable (PaddingValues) -> Unit
) {
    val navigationItems = listOf(
        "home" to "Home",
        "focus" to "Focus",
        "tasks" to "Tasks",
        "habits" to "Habits",
        "room" to "Room",
        "clock" to "Clock",
        "ai" to "AI",
        "settings" to "Settings"
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                navigationItems.forEach { (destination, label) ->
                    NavigationBarItem(
                        selected = currentDestination == destination,
                        onClick = { onDestinationSelected(destination) },
                        label = { Text(label) },
                        icon = { Text("📱") }
                    )
                }
            }
        }
    ) { innerPadding ->
        content(innerPadding)
    }
}
