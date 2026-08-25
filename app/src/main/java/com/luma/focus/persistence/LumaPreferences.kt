package com.luma.focus.persistence

import android.content.Context
import android.content.SharedPreferences
import com.luma.focus.model.FocusConfiguration
import com.luma.focus.model.PomodoroMode
import kotlinx.serialization.json.Json

class LumaPreferences(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences(
        "luma_prefs",
        Context.MODE_PRIVATE
    )
    
    // Theme preferences
    var darkMode: Boolean
        get() = prefs.getBoolean("dark_mode", false)
        set(value) = prefs.edit().putBoolean("dark_mode", value).apply()
    
    var animationsEnabled: Boolean
        get() = prefs.getBoolean("animations_enabled", true)
        set(value) = prefs.edit().putBoolean("animations_enabled", value).apply()
    
    // Focus configuration
    var focusDuration: Long
        get() = prefs.getLong("focus_duration", 25 * 60)
        set(value) = prefs.edit().putLong("focus_duration", value).apply()
    
    var shortBreakDuration: Long
        get() = prefs.getLong("short_break_duration", 5 * 60)
        set(value) = prefs.edit().putLong("short_break_duration", value).apply()
    
    var longBreakDuration: Long
        get() = prefs.getLong("long_break_duration", 15 * 60)
        set(value) = prefs.edit().putLong("long_break_duration", value).apply()
    
    var sessionsBeforeLongBreak: Int
        get() = prefs.getInt("sessions_before_long_break", 4)
        set(value) = prefs.edit().putInt("sessions_before_long_break", value).apply()
    
    var autoStartNextSession: Boolean
        get() = prefs.getBoolean("auto_start_next", false)
        set(value) = prefs.edit().putBoolean("auto_start_next", value).apply()
    
    var autoStartBreak: Boolean
        get() = prefs.getBoolean("auto_start_break", false)
        set(value) = prefs.edit().putBoolean("auto_start_break", value).apply()
    
    // Sound preferences
    var soundEnabled: Boolean
        get() = prefs.getBoolean("sound_enabled", true)
        set(value) = prefs.edit().putBoolean("sound_enabled", value).apply()
    
    var soundVolume: Float
        get() = prefs.getFloat("sound_volume", 0.8f)
        set(value) = prefs.edit().putFloat("sound_volume", value).apply()
    
    var focusSound: String
        get() = prefs.getString("focus_sound", "rain") ?: "rain"
        set(value) = prefs.edit().putString("focus_sound", value).apply()
    
    var breakSound: String
        get() = prefs.getString("break_sound", "birds") ?: "birds"
        set(value) = prefs.edit().putString("break_sound", value).apply()
    
    var alarmSound: String
        get() = prefs.getString("alarm_sound", "chime") ?: "chime"
        set(value) = prefs.edit().putString("alarm_sound", value).apply()
    
    // Vibration
    var vibrationEnabled: Boolean
        get() = prefs.getBoolean("vibration_enabled", true)
        set(value) = prefs.edit().putBoolean("vibration_enabled", value).apply()
    
    // Wallpaper
    var selectedWallpaper: String
        get() = prefs.getString("selected_wallpaper", "forest") ?: "forest"
        set(value) = prefs.edit().putString("selected_wallpaper", value).apply()
    
    // Pomodoro mode
    var pomodoroMode: String
        get() = prefs.getString("pomodoro_mode", PomodoroMode.STANDARD.name) ?: PomodoroMode.STANDARD.name
        set(value) = prefs.edit().putString("pomodoro_mode", value).apply()
    
    // Accessibility
    var largeText: Boolean
        get() = prefs.getBoolean("large_text", false)
        set(value) = prefs.edit().putBoolean("large_text", value).apply()
    
    var reduceMotion: Boolean
        get() = prefs.getBoolean("reduce_motion", false)
        set(value) = prefs.edit().putBoolean("reduce_motion", value).apply()
    
    var highContrast: Boolean
        get() = prefs.getBoolean("high_contrast", false)
        set(value) = prefs.edit().putBoolean("high_contrast", value).apply()
    
    // AI preferences
    var aiEnabled: Boolean
        get() = prefs.getBoolean("ai_enabled", false)
        set(value) = prefs.edit().putBoolean("ai_enabled", value).apply()
    
    var aiProvider: String
        get() = prefs.getString("ai_provider", "openai") ?: "openai"
        set(value) = prefs.edit().putString("ai_provider", value).apply()
    
    var aiApiKey: String?
        get() = prefs.getString("ai_api_key", null)
        set(value) = if (value != null) prefs.edit().putString("ai_api_key", value).apply() else prefs.edit().remove("ai_api_key").apply()
}
