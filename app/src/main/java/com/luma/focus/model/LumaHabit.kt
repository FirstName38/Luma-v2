package com.luma.focus.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LumaHabit(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val icon: String = "leaf",
    val label: String = "",
    val startDate: String = "",
    val targetDays: Int = 30,
    val schedule: List<Int> = (0..6).toList(),  // 0=Monday, 6=Sunday
    val reminder: String? = null,
    val color: String = "#D4956E",
    val dailyCompletion: Map<Int, Float> = emptyMap()  // day -> completion percentage
) : Parcelable

@Parcelize
data class HabitDay(
    val day: Int,
    val completion: Float = 0f  // 0f to 1f
) : Parcelable
