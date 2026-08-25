package com.luma.focus.analytics

import com.luma.focus.model.FocusSession
import com.luma.focus.persistence.entity.FocusSessionEntity
import com.luma.focus.persistence.entity.TaskEntity
import com.luma.focus.persistence.entity.HabitEntity

data class DailyStats(
    val date: String = "",
    val totalFocusTime: Long = 0,
    val sessionCount: Int = 0,
    val taskCount: Int = 0,
    val averageSessionDuration: Long = 0
)

data class WeeklyStats(
    val week: String = "",
    val totalFocusTime: Long = 0,
    val sessionCount: Int = 0,
    val bestDay: String = "",
    val totalTasksCompleted: Int = 0
)

class LocalAnalyticsEngine {
    fun calculateDailyStats(sessions: List<FocusSessionEntity>, date: String): DailyStats {
        val daySessions = sessions.filter { it.date == date }
        val totalFocus = daySessions.sumOf { it.actualFocusDuration }
        val avgSession = if (daySessions.isNotEmpty()) totalFocus / daySessions.size else 0L
        
        return DailyStats(
            date = date,
            totalFocusTime = totalFocus,
            sessionCount = daySessions.size,
            averageSessionDuration = avgSession
        )
    }
    
    fun calculateWeeklyStats(sessions: List<FocusSessionEntity>): WeeklyStats {
        val totalFocus = sessions.sumOf { it.actualFocusDuration }
        val totalSessions = sessions.size
        
        val bestDay = sessions.groupBy { it.date }
            .maxByOrNull { (_, daySessions) -> daySessions.sumOf { it.actualFocusDuration } }
            ?.key ?: ""
        
        return WeeklyStats(
            week = "current",
            totalFocusTime = totalFocus,
            sessionCount = totalSessions,
            bestDay = bestDay
        )
    }
    
    fun getMostProductiveHour(sessions: List<FocusSessionEntity>): String {
        return sessions.groupBy { it.startTime.split(":")[0] }
            .maxByOrNull { (_, daySessions) -> daySessions.sumOf { it.actualFocusDuration } }
            ?.key?.let { it + ":00" } ?: "Unknown"
    }
    
    fun getPauseRatio(sessions: List<FocusSessionEntity>): Float {
        val totalPauses = sessions.sumOf { it.totalPauseDuration }
        val totalFocus = sessions.sumOf { it.actualFocusDuration }
        return if (totalFocus > 0) totalPauses.toFloat() / totalFocus else 0f
    }
}
