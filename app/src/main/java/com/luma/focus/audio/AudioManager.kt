package com.luma.focus.audio

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Build
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.luma.focus.R

class LumaAudioManager(private val context: Context) {
    private var exoPlayer: ExoPlayer? = null
    private var soundPool: SoundPool? = null
    private val soundMap = mutableMapOf<String, Int>()
    private var currentBackgroundSound: String? = null
    
    init {
        initializeSoundPool()
        initializeExoPlayer()
        loadSounds()
    }
    
    private fun initializeSoundPool() {
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .build()
        
        soundPool = SoundPool.Builder()
            .setMaxStreams(5)
            .setAudioAttributes(audioAttributes)
            .build()
    }
    
    private fun initializeExoPlayer() {
        exoPlayer = ExoPlayer.Builder(context).build()
        exoPlayer?.repeatMode = Player.REPEAT_MODE_ONE
    }
    
    private fun loadSounds() {
        // Load notification sounds from resources
        // These are just placeholders - add actual sound files to res/raw/
    }
    
    fun playBackgroundSound(soundName: String, volume: Float = 0.8f) {
        currentBackgroundSound = soundName
        
        // Map sound name to resource ID
        val resourceId = when (soundName) {
            "rain" -> R.raw.sound_rain
            "forest" -> R.raw.sound_forest
            "ocean" -> R.raw.sound_ocean
            "cafe" -> R.raw.sound_cafe
            "birds" -> R.raw.sound_birds
            else -> return
        }
        
        try {
            val mediaItem = MediaItem.fromUri("android.resource://${context.packageName}/$resourceId")
            exoPlayer?.setMediaItem(mediaItem)
            exoPlayer?.volume = volume
            exoPlayer?.prepare()
            exoPlayer?.play()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    
    fun stopBackgroundSound() {
        exoPlayer?.stop()
        currentBackgroundSound = null
    }
    
    fun pauseBackgroundSound() {
        exoPlayer?.pause()
    }
    
    fun resumeBackgroundSound() {
        exoPlayer?.play()
    }
    
    fun setVolume(volume: Float) {
        exoPlayer?.volume = volume.coerceIn(0f, 1f)
    }
    
    fun playAlarmSound(soundName: String = "chime") {
        // Play alarm/notification sound
    }
    
    fun playCompletionSound() {
        // Play session completion sound
    }
    
    fun release() {
        exoPlayer?.release()
        soundPool?.release()
    }
}
