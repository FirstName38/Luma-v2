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

@Composable
fun ClockScreen(
    innerPadding: PaddingValues
) {
    var selectedTab by remember { mutableStateOf("Alarm") }
    val tabs = listOf("Alarm", "Timer", "Stopwatch", "World Clock")
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp)
    ) {
        Text(
            text = "Clock",
            style = MaterialTheme.typography.displaySmall
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Tab selector
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            tabs.forEach { tab ->
                Button(
                    onClick = { selectedTab = tab },
                    modifier = Modifier.weight(1f),
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        containerColor = if (selectedTab == tab)
                            MaterialTheme.colorScheme.primary
                        else
                            MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Text(tab, fontSize = 12.sp)
                }
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        when (selectedTab) {
            "Alarm" -> AlarmTabContent()
            "Timer" -> TimerTabContent()
            "Stopwatch" -> StopwatchTabContent()
            "World Clock" -> WorldClockTabContent()
        }
    }
}

@Composable
fun AlarmTabContent() {
    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("6:30 AM", style = MaterialTheme.typography.headlineMedium)
                Text("Weekdays", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Composable
fun TimerTabContent() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("5:00", style = MaterialTheme.typography.displayMedium, fontSize = 60.sp)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {}) {
            Text("START TIMER")
        }
    }
}

@Composable
fun StopwatchTabContent() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("0:00:00", style = MaterialTheme.typography.displayMedium, fontSize = 60.sp)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {}) {
            Text("START")
        }
    }
}

@Composable
fun WorldClockTabContent() {
    Column {
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
                Column(modifier = Modifier.weight(1f)) {
                    Text("New York", style = MaterialTheme.typography.titleMedium)
                    Text("2:30 PM", style = MaterialTheme.typography.bodySmall)
                }
                Text("🗽", style = MaterialTheme.typography.headlineMedium)
            }
        }
    }
}
