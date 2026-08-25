package com.luma.focus.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.luma.focus.model.TaskPriority
import com.luma.focus.ui.components.TaskCard

@Composable
fun TasksScreen(
    innerPadding: PaddingValues
) {
    var selectedDate by remember { mutableStateOf("Today") }
    val tasks = remember {
        listOf(
            Triple("Physics Assignment", TaskPriority.URGENT, false),
            Triple("Study Notes", TaskPriority.HIGH, false),
            Triple("Review Slides", TaskPriority.MEDIUM, true)
        )
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Tasks",
                style = MaterialTheme.typography.displaySmall
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Date selector
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp)
            ) {
                listOf("Yesterday", "Today", "Tomorrow").forEach { date ->
                    Button(
                        onClick = { selectedDate = date },
                        modifier = Modifier.weight(1f),
                        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                            containerColor = if (selectedDate == date) 
                                MaterialTheme.colorScheme.primary 
                            else 
                                MaterialTheme.colorScheme.surfaceVariant
                        )
                    ) {
                        Text(date)
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Task list
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp)
            ) {
                items(tasks) { (title, priority, completed) ->
                    TaskCard(
                        title = title,
                        priority = priority,
                        completed = completed
                    )
                }
            }
        }
        
        // FAB
        FloatingActionButton(
            onClick = {},
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            containerColor = MaterialTheme.colorScheme.primary
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add Task")
        }
    }
}
