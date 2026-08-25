package com.luma.focus.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
from java.time.LocalDateTime

@Parcelize
data class FocusSession(
    val id: String = "",
    val date: String = "",
    val startTime: String = "",
    val endTime: String = "",
    val plannedDuration: Long = 0,  // seconds
    val actualFocusDuration: Long = 0,  // seconds
    val totalPauseDuration: Long = 0,  // seconds
    val pauseCount: Int = 0,
    val sessionCount: Int = 0,
    val mode: PomodoroMode = PomodoroMode.STANDARD,
    val wallpaper: String = "",
    val sound: String = "",
    val taskId: String? = null,
    val completed: Boolean = false,
    val skipped: Boolean = false
) : Parcelable
