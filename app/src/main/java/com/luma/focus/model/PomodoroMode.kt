package com.luma.focus.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FocusConfiguration(
    val mode: PomodoroMode = PomodoroMode.STANDARD,
    val focusDuration: Long = 25 * 60,  // seconds
    val shortBreakDuration: Long = 5 * 60,
    val longBreakDuration: Long = 15 * 60,
    val sessionsBeforeLongBreak: Int = 4,
    val autoStartNextSession: Boolean = false,
    val autoStartBreak: Boolean = false,
    val soundEnabled: Boolean = true,
    val vibrationEnabled: Boolean = true,
    val focusSound: String = "rain",
    val breakSound: String = "birds",
    val alarmSound: String = "chime",
    val volume: Float = 0.8f,
    val selectedWallpaper: String = "forest",
    val animationsEnabled: Boolean = true
) : Parcelable

enum class PomodoroMode {
    STANDARD,
    ADHD,
    CUSTOM
}

enum class TimerPhase {
    FOCUS,
    SHORT_BREAK,
    LONG_BREAK
}

enum class TimerState {
    IDLE,
    RUNNING,
    PAUSED,
    COMPLETED,
    SKIPPED
}
