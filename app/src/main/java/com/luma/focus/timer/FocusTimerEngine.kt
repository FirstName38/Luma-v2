package com.luma.focus.timer

import com.luma.focus.model.FocusConfiguration
import com.luma.focus.model.FocusSession
import com.luma.focus.model.PomodoroMode
import com.luma.focus.model.TimerPhase
import com.luma.focus.model.TimerState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FocusTimerEngine {
    private val _timerState = MutableStateFlow(TimerState.IDLE)
    val timerState: StateFlow<TimerState> = _timerState.asStateFlow()
    
    private val _currentPhase = MutableStateFlow(TimerPhase.FOCUS)
    val currentPhase: StateFlow<TimerPhase> = _currentPhase.asStateFlow()
    
    private val _timeRemaining = MutableStateFlow(25 * 60)
    val timeRemaining: StateFlow<Int> = _timeRemaining.asStateFlow()
    
    private val _sessionCount = MutableStateFlow(1)
    val sessionCount: StateFlow<Int> = _sessionCount.asStateFlow()
    
    private val _totalPaused = MutableStateFlow(0L)
    val totalPaused: StateFlow<Long> = _totalPaused.asStateFlow()
    
    private var timerJob: Job? = null
    private var currentConfiguration: FocusConfiguration? = null
    private var sessionStartTime = 0L
    private var pauseStartTime = 0L
    
    fun start(configuration: FocusConfiguration) {
        currentConfiguration = configuration
        _timerState.value = TimerState.RUNNING
        sessionStartTime = System.currentTimeMillis()
        _timeRemaining.value = configuration.focusDuration.toInt()
        _currentPhase.value = TimerPhase.FOCUS
        _sessionCount.value = 1
        
        startTimer()
    }
    
    fun pause() {
        if (_timerState.value == TimerState.RUNNING) {
            _timerState.value = TimerState.PAUSED
            pauseStartTime = System.currentTimeMillis()
            timerJob?.cancel()
        }
    }
    
    fun resume() {
        if (_timerState.value == TimerState.PAUSED) {
            _timerState.value = TimerState.RUNNING
            _totalPaused.value += System.currentTimeMillis() - pauseStartTime
            startTimer()
        }
    }
    
    fun reset() {
        timerJob?.cancel()
        _timerState.value = TimerState.IDLE
        _timeRemaining.value = 25 * 60
        _sessionCount.value = 1
        _totalPaused.value = 0L
        _currentPhase.value = TimerPhase.FOCUS
    }
    
    fun skip() {
        timerJob?.cancel()
        advancePhase()
        startTimer()
    }
    
    private fun startTimer() {
        timerJob?.cancel()
        timerJob = kotlinx.coroutines.GlobalScope.launch {
            while (_timerState.value == TimerState.RUNNING && _timeRemaining.value > 0) {
                delay(1000)
                _timeRemaining.value = (_timeRemaining.value - 1).coerceAtLeast(0)
                
                if (_timeRemaining.value == 0) {
                    _timerState.value = TimerState.COMPLETED
                    onPhaseComplete()
                }
            }
        }
    }
    
    private fun onPhaseComplete() {
        val config = currentConfiguration ?: return
        
        when (_currentPhase.value) {
            TimerPhase.FOCUS -> {
                if (_sessionCount.value % config.sessionsBeforeLongBreak == 0) {
                    _currentPhase.value = TimerPhase.LONG_BREAK
                    _timeRemaining.value = config.longBreakDuration.toInt()
                } else {
                    _currentPhase.value = TimerPhase.SHORT_BREAK
                    _timeRemaining.value = config.shortBreakDuration.toInt()
                }
            }
            TimerPhase.SHORT_BREAK -> {
                _currentPhase.value = TimerPhase.FOCUS
                _sessionCount.value += 1
                _timeRemaining.value = config.focusDuration.toInt()
            }
            TimerPhase.LONG_BREAK -> {
                _currentPhase.value = TimerPhase.FOCUS
                _sessionCount.value = 1
                _timeRemaining.value = config.focusDuration.toInt()
            }
        }
        
        if (config.autoStartNextSession && _timerState.value == TimerState.COMPLETED) {
            _timerState.value = TimerState.RUNNING
            startTimer()
        }
    }
    
    private fun advancePhase() {
        val config = currentConfiguration ?: return
        
        when (_currentPhase.value) {
            TimerPhase.FOCUS -> {
                _currentPhase.value = TimerPhase.SHORT_BREAK
                _timeRemaining.value = config.shortBreakDuration.toInt()
            }
            TimerPhase.SHORT_BREAK -> {
                _currentPhase.value = TimerPhase.FOCUS
                _sessionCount.value += 1
                _timeRemaining.value = config.focusDuration.toInt()
            }
            TimerPhase.LONG_BREAK -> {
                _currentPhase.value = TimerPhase.FOCUS
                _sessionCount.value = 1
                _timeRemaining.value = config.focusDuration.toInt()
            }
        }
    }
    
    fun getFormattedTime(): String {
        val seconds = _timeRemaining.value
        val minutes = seconds / 60
        val secs = seconds % 60
        return String.format("%02d:%02d", minutes, secs)
    }
}
