package com.luma.focus

import android.content.Context
import com.luma.focus.audio.LumaAudioManager
import com.luma.focus.persistence.LumaDatabase
import com.luma.focus.persistence.LumaPreferences
import com.luma.focus.ai.AIRepository
import com.luma.focus.timer.FocusTimerEngine
import com.luma.focus.analytics.LocalAnalyticsEngine

/**
 * Service Locator / Dependency Injection
 * Provides singleton instances of key services
 */
object LumaServices {
    private var appContext: Context? = null
    private var preferences: LumaPreferences? = null
    private var database: LumaDatabase? = null
    private var audioManager: LumaAudioManager? = null
    private var timerEngine: FocusTimerEngine? = null
    private var aiRepository: AIRepository? = null
    private var analyticsEngine: LocalAnalyticsEngine? = null
    
    fun initialize(context: Context) {
        appContext = context.applicationContext
        preferences = LumaPreferences(context)
        database = LumaDatabase.getInstance(context)
        audioManager = LumaAudioManager(context)
        timerEngine = FocusTimerEngine()
        aiRepository = AIRepository()
        analyticsEngine = LocalAnalyticsEngine()
    }
    
    fun getPreferences(): LumaPreferences = preferences ?: error("LumaServices not initialized")
    fun getDatabase(): LumaDatabase = database ?: error("LumaServices not initialized")
    fun getAudioManager(): LumaAudioManager = audioManager ?: error("LumaServices not initialized")
    fun getTimerEngine(): FocusTimerEngine = timerEngine ?: error("LumaServices not initialized")
    fun getAIRepository(): AIRepository = aiRepository ?: error("LumaServices not initialized")
    fun getAnalyticsEngine(): LocalAnalyticsEngine = analyticsEngine ?: error("LumaServices not initialized")
}
