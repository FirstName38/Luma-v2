package com.luma.focus.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.luma.focus.model.TaskPriority

@Composable
fun TaskCard(
    title: String,
    priority: TaskPriority,
    completed: Boolean = false,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Priority indicator
            Box(
                modifier = Modifier
                    .width(8.dp)
                    .height(40.dp)
                    .background(
                        color = when (priority) {
                            TaskPriority.ULTRA_URGENT -> Color(0xFFD32F2F)
                            TaskPriority.URGENT -> Color(0xFFFF6F00)
                            TaskPriority.HIGH -> Color(0xFFFBC02D)
                            TaskPriority.MEDIUM -> Color(0xFF1976D2)
                            TaskPriority.LOW -> Color(0xFF388E3C)
                            else -> Color(0xFF9E9E9E)
                        },
                        shape = RoundedCornerShape(4.dp)
                    )
            )
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = priority.name,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
