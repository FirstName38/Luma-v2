package com.luma.focus.ai

import com.luma.focus.persistence.entity.FocusSessionEntity
import com.luma.focus.persistence.entity.TaskEntity
import com.luma.focus.persistence.entity.HabitEntity

data class AnalyticsPromptContext(
    val focusHistory: List<FocusSessionEntity> = emptyList(),
    val taskHistory: List<TaskEntity> = emptyList(),
    val habitHistory: List<HabitEntity> = emptyList(),
    val timeRange: String = "7d"
)

interface AIProvider {
    suspend fun chat(message: String, context: AnalyticsPromptContext): String
    suspend fun analyzeProductivity(context: AnalyticsPromptContext): String
    suspend fun getRecommendations(context: AnalyticsPromptContext): String
}

class MockAIProvider : AIProvider {
    override suspend fun chat(message: String, context: AnalyticsPromptContext): String {
        return "AI analysis: $message\n\nBased on your ${context.focusHistory.size} focus sessions in the last ${context.timeRange}."
    }
    
    override suspend fun analyzeProductivity(context: AnalyticsPromptContext): String {
        val totalFocus = context.focusHistory.sumOf { it.actualFocusDuration }
        val hours = totalFocus / 3600
        return "You've focused for approximately $hours hours with ${context.focusHistory.size} sessions."
    }
    
    override suspend fun getRecommendations(context: AnalyticsPromptContext): String {
        return "Try focusing during your peak hours. Consider using nature sounds during focus sessions."
    }
}

class AIRepository {
    private var provider: AIProvider = MockAIProvider()
    
    fun setProvider(newProvider: AIProvider) {
        provider = newProvider
    }
    
    suspend fun chat(message: String, context: AnalyticsPromptContext): String {
        return provider.chat(message, context)
    }
    
    suspend fun analyzeProductivity(context: AnalyticsPromptContext): String {
        return provider.analyzeProductivity(context)
    }
    
    suspend fun getRecommendations(context: AnalyticsPromptContext): String {
        return provider.getRecommendations(context)
    }
}
