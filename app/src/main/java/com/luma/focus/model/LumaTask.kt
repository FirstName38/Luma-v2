package com.luma.focus.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LumaTask(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val date: String = "",
    val time: String? = null,
    val deadline: String? = null,
    val priority: TaskPriority = TaskPriority.MEDIUM,
    val labels: List<String> = emptyList(),
    val estimatedDuration: Long = 0,  // minutes
    val actualFocusDuration: Long = 0,  // seconds
    val completed: Boolean = false,
    val focusSessionIds: List<String> = emptyList(),
    val notes: String = ""
) : Parcelable

enum class TaskPriority {
    ULTRA_URGENT,
    URGENT,
    HIGH,
    MEDIUM,
    LOW,
    SOMEDAY,
    NONE
}
