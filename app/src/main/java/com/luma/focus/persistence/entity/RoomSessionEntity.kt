package com.luma.focus.persistence.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "room_sessions")
data class RoomSessionEntity(
    @PrimaryKey val id: String = "",
    val date: String = "",
    val startTime: String = "",
    val endTime: String = "",
    val totalRoomDuration: Long = 0,
    val focusDuration: Long = 0,
    val pauseCount: Int = 0,
    val pauseDuration: Long = 0,
    val sessionCount: Int = 0,
    val taskId: String? = null,
    val mode: String = "STANDARD",
    val cameraEnabled: Boolean = true,
    val microphoneEnabled: Boolean = true,
    val completed: Boolean = false
)
