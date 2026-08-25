package com.luma.focus.persistence.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habits")
data class HabitEntity(
    @PrimaryKey val id: String = "",
    val name: String = "",
    val description: String = "",
    val icon: String = "leaf",
    val label: String = "",
    val startDate: String = "",
    val targetDays: Int = 30,
    val schedule: String = "",  // JSON array as string
    val reminder: String? = null,
    val color: String = "#D4956E",
    val dailyCompletion: String = "{}"  // JSON object as string
)
