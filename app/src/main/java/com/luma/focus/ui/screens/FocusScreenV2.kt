package com.luma.focus.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luma.focus.model.TimerPhase
import com.luma.focus.model.TimerState
import com.luma.focus.ui.components.TimerDisplay

@Composable
fun FocusScreen(
    innerPadding: PaddingValues
) {
    var timerState by remember { mutableStateOf(TimerState.IDLE) }
    var timeRemaining by remember { mutableStateOf("25:00") }
    var currentPhase by remember { mutableStateOf(TimerPhase.FOCUS) }
    var sessionCount by remember { mutableStateOf(1) }
    var totalSessions by remember { mutableStateOf(4) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Focus Session",
            style = MaterialTheme.typography.displaySmall
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Timer Display
        TimerDisplay(
            timeRemaining = timeRemaining,
            currentPhase = currentPhase,
            sessionCount = sessionCount,
            totalSessions = totalSessions
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Control Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                onClick = {
                    timerState = when (timerState) {
                        TimerState.IDLE -> TimerState.RUNNING
                        TimerState.RUNNING -> TimerState.PAUSED
                        TimerState.PAUSED -> TimerState.RUNNING
                        else -> TimerState.IDLE
                    }
                },
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = when (timerState) {
                        TimerState.IDLE -> "START"
                        TimerState.RUNNING -> "PAUSE"
                        TimerState.PAUSED -> "RESUME"
                        else -> "START"
                    },
                    fontSize = 16.sp
                )
            }
            
            Button(
                onClick = {
                    timerState = TimerState.IDLE
                    timeRemaining = "25:00"
                },
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                )
            ) {
                Text("RESET")
            }
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        Button(
            onClick = { /* Skip to next phase */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.tertiary
            )
        ) {
            Text("SKIP")
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Settings
        Text(
            text = "Session Settings",
            style = MaterialTheme.typography.headlineSmall
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Wallpaper: Forest | Sound: Rain",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("CUSTOMIZE SESSION")
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("OPEN SETTINGS")
        }
    }
}
