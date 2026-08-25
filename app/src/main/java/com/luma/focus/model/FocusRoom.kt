package com.luma.focus.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FocusRoomSession(
    val id: String = "",
    val date: String = "",
    val startTime: String = "",
    val endTime: String = "",
    val totalRoomDuration: Long = 0,  // seconds
    val focusDuration: Long = 0,  // seconds
    val pauseCount: Int = 0,
    val pauseDuration: Long = 0,  // seconds
    val sessionCount: Int = 0,
    val taskId: String? = null,
    val mode: PomodoroMode = PomodoroMode.STANDARD,
    val cameraEnabled: Boolean = true,
    val microphoneEnabled: Boolean = true,
    val completed: Boolean = false
) : Parcelable
