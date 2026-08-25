package com.luma.focus.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AIScreen(
    innerPadding: PaddingValues
) {
    var chatMessage by remember { mutableStateOf("") }
    var chatHistory by remember { mutableStateOf(listOf<Pair<String, String>>()) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp)
    ) {
        Text(
            text = "Luma AI",
            style = MaterialTheme.typography.displaySmall
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Daily Insight Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Today's Insight",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "You've been most productive between 9 AM - 11 AM. Consider scheduling important tasks during these hours.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Statistics
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "This Week's Stats",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Total Focus: 12h 42m",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Sessions: 48",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Average Duration: 16m 30s",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Chat Section
        Text(
            text = "Ask Luma",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(12.dp))
        
        // Chat History
        if (chatHistory.isNotEmpty()) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    chatHistory.forEach { (user, ai) ->
                        Text(
                            text = "You: $user",
                            style = MaterialTheme.typography.bodySmall
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Luma: $ai",
                            style = MaterialTheme.typography.bodySmall
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Quick Actions
        Button(
            onClick = { chatHistory = chatHistory + ("Why was I less productive yesterday?" to "Based on your data...") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Why was I less productive yesterday?")
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Button(
            onClick = { chatHistory = chatHistory + ("What's my best focus time?" to "Your data shows...") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("What's my best focus time?")
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Button(
            onClick = { chatHistory = chatHistory + ("Build me a focus plan for today" to "Here's your plan...") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Build me a focus plan for today")
        }
    }
}
