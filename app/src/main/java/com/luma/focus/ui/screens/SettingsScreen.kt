package com.luma.focus.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(
    innerPadding: PaddingValues
) {
    var animationsEnabled by remember { mutableStateOf(true) }
    var soundEnabled by remember { mutableStateOf(true) }
    var vibrationEnabled by remember { mutableStateOf(true) }
    var soundVolume by remember { mutableStateOf(0.8f) }
    var focusDuration by remember { mutableStateOf(25) }
    var breakDuration by remember { mutableStateOf(5) }
    var longBreakDuration by remember { mutableStateOf(15) }
    var sessionsBeforeLongBreak by remember { mutableStateOf(4) }
    var autoStartNext by remember { mutableStateOf(false) }
    var aiEnabled by remember { mutableStateOf(false) }
    var aiApiKey by remember { mutableStateOf("") }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.displaySmall
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Appearance Settings
        Text(
            text = "Appearance",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(12.dp))
        
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Enable Animations", modifier = Modifier.weight(1f))
                Switch(
                    checked = animationsEnabled,
                    onCheckedChange = { animationsEnabled = it }
                )
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Sound Settings
        Text(
            text = "Sound",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(12.dp))
        
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Enable Sound", modifier = Modifier.weight(1f))
                    Switch(
                        checked = soundEnabled,
                        onCheckedChange = { soundEnabled = it }
                    )
                }
                
                Text("Volume: ${(soundVolume * 100).toInt()}%")
                Slider(
                    value = soundVolume,
                    onValueChange = { soundVolume = it },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Vibration", modifier = Modifier.weight(1f))
                Switch(
                    checked = vibrationEnabled,
                    onCheckedChange = { vibrationEnabled = it }
                )
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Focus Settings
        Text(
            text = "Focus Timer",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(12.dp))
        
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Focus Duration: $focusDuration minutes")
                Slider(
                    value = focusDuration.toFloat(),
                    onValueChange = { focusDuration = it.toInt() },
                    valueRange = 5f..60f,
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(12.dp))
                
                Text("Short Break: $breakDuration minutes")
                Slider(
                    value = breakDuration.toFloat(),
                    onValueChange = { breakDuration = it.toInt() },
                    valueRange = 1f..15f,
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(12.dp))
                
                Text("Long Break: $longBreakDuration minutes")
                Slider(
                    value = longBreakDuration.toFloat(),
                    onValueChange = { longBreakDuration = it.toInt() },
                    valueRange = 10f..45f,
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(12.dp))
                
                Text("Sessions Before Long Break: $sessionsBeforeLongBreak")
                Slider(
                    value = sessionsBeforeLongBreak.toFloat(),
                    onValueChange = { sessionsBeforeLongBreak = it.toInt() },
                    valueRange = 2f..8f,
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(12.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Auto-start Next", modifier = Modifier.weight(1f))
                    Switch(
                        checked = autoStartNext,
                        onCheckedChange = { autoStartNext = it }
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // AI Settings
        Text(
            text = "Luma AI",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(12.dp))
        
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Enable AI", modifier = Modifier.weight(1f))
                    Switch(
                        checked = aiEnabled,
                        onCheckedChange = { aiEnabled = it }
                    )
                }
                
                if (aiEnabled) {
                    Text("API Key (optional)")
                    TextField(
                        value = aiApiKey,
                        onValueChange = { aiApiKey = it },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Luma AI works locally without an API key. Add a key to enable advanced AI features.",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Data Management
        Text(
            text = "Data",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(12.dp))
        
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Export History")
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Import Data")
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Clear History")
        }
    }
}
