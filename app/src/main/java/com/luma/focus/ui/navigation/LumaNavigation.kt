package com.luma.focus.ui.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class NavigationItem(
    val id: String,
    val label: String,
    val icon: androidx.compose.material.icons.filled.Icon?
)

@Composable
fun LumaAdaptiveNavigation(
    currentDestination: String,
    onDestinationSelected: (String) -> Unit,
    isTablet: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable (PaddingValues) -> Unit
) {
    val navigationItems = listOf(
        NavigationItem("home", "Home", Icons.Filled.Home),
        NavigationItem("focus", "Focus", Icons.Filled.Timer),
        NavigationItem("tasks", "Tasks", null),
        NavigationItem("habits", "Habits", null),
        NavigationItem("room", "Room", null),
        NavigationItem("clock", "Clock", null),
        NavigationItem("ai", "AI", null),
        NavigationItem("settings", "Settings", Icons.Filled.Settings)
    )

    if (isTablet) {
        // Tablet: Navigation Rail on left side
        Row(
            modifier = modifier.fillMaxSize()
        ) {
            NavigationRail(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(80.dp),
                containerColor = androidx.compose.material3.MaterialTheme.colorScheme.surface
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                navigationItems.forEach { item ->
                    NavigationRailItem(
                        selected = item.id == currentDestination,
                        onClick = { onDestinationSelected(item.id) },
                        icon = {
                            if (item.icon != null) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.label
                                )
                            } else {
                                Text(
                                    text = item.label.first().toString(),
                                    style = androidx.compose.material3.MaterialTheme.typography.labelSmall
                                )
                            }
                        },
                        label = { Text(item.label, style = androidx.compose.material3.MaterialTheme.typography.labelSmall) }
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                content(PaddingValues(0.dp))
            }
        }
    } else {
        // Phone: Bottom Navigation
        Scaffold(
            modifier = modifier.fillMaxSize(),
            bottomBar = {
                NavigationBar(
                    modifier = Modifier.fillMaxWidth(),
                    containerColor = androidx.compose.material3.MaterialTheme.colorScheme.surface
                ) {
                    navigationItems.forEach { item ->
                        NavigationBarItem(
                            selected = item.id == currentDestination,
                            onClick = { onDestinationSelected(item.id) },
                            icon = {
                                if (item.icon != null) {
                                    Icon(
                                        imageVector = item.icon,
                                        contentDescription = item.label
                                    )
                                } else {
                                    Text(
                                        text = item.label.first().toString(),
                                        style = androidx.compose.material3.MaterialTheme.typography.labelSmall
                                    )
                                }
                            },
                            label = { Text(item.label) }
                        )
                    }
                }
            }
        ) { innerPadding ->
            content(innerPadding)
        }
    }
}
