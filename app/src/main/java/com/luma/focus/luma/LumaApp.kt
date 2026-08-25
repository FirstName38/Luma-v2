package com.luma.focus.luma

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import com.luma.focus.theme.LumaTheme
import com.luma.focus.ui.navigation.LumaAdaptiveNavigation
import com.luma.focus.ui.screens.AIScreen
import com.luma.focus.ui.screens.ClockScreenV2
import com.luma.focus.ui.screens.FocusScreenV2
import com.luma.focus.ui.screens.HabitsScreenV2
import com.luma.focus.ui.screens.HomeScreen
import com.luma.focus.ui.screens.RoomScreenV2
import com.luma.focus.ui.screens.SettingsScreen
import com.luma.focus.ui.screens.TasksScreenV2

@Composable
fun LumaApp() {
    LumaTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            var currentDestination by remember { mutableStateOf("home") }
            
            // Determine if device is tablet (min 600dp width)
            val configuration = LocalConfiguration.current
            val isTablet = configuration.screenWidthDp >= 600
            
            LumaAdaptiveNavigation(
                currentDestination = currentDestination,
                onDestinationSelected = { currentDestination = it },
                isTablet = isTablet
            ) { innerPadding ->
                when (currentDestination) {
                    "home" -> HomeScreen(innerPadding)
                    "focus" -> FocusScreenV2(innerPadding)
                    "tasks" -> TasksScreenV2(innerPadding)
                    "habits" -> HabitsScreenV2(innerPadding)
                    "room" -> RoomScreenV2(innerPadding)
                    "clock" -> ClockScreenV2(innerPadding)
                    "ai" -> AIScreen(innerPadding)
                    "settings" -> SettingsScreen(innerPadding)
                    else -> HomeScreen(innerPadding)
                }
            }
        }
    }
}
