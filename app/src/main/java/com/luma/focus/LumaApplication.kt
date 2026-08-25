package com.luma.focus

import android.app.Application
import com.luma.focus.timer.FocusTimerEngine

class LumaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize services
        initializeServices()
    }
    
    private fun initializeServices() {
        // Initialize Luma services
        try {
            LumaServices.initialize(this)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
