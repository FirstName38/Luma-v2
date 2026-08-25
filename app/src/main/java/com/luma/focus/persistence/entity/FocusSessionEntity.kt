package com.luma.focus.persistence.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "focus_sessions")
data class FocusSessionEntity(
    @PrimaryKey val id: String = "",
    val date: String = "",
    val startTime: String = "",
    val endTime: String = "",
    val plannedDuration: Long = 0,
    val actualFocusDuration: Long = 0,
    val totalPauseDuration: Long = 0,
    val pauseCount: Int = 0,
    val sessionCount: Int = 0,
    val mode: String = "STANDARD",
    val wallpaper: String = "",
    val sound: String = "",
    val taskId: String? = null,
    val completed: Boolean = false,
    val skipped: Boolean = false
)
