package com.luma.focus.persistence.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey val id: String = "",
    val title: String = "",
    val description: String = "",
    val date: String = "",
    val time: String? = null,
    val deadline: String? = null,
    val priority: String = "MEDIUM",
    val labels: String = "",  // JSON array as string
    val estimatedDuration: Long = 0,
    val actualFocusDuration: Long = 0,
    val completed: Boolean = false,
    val focusSessionIds: String = "",  // JSON array as string
    val notes: String = ""
)
