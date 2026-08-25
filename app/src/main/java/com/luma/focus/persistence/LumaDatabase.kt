package com.luma.focus.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.luma.focus.persistence.dao.FocusSessionDao
import com.luma.focus.persistence.dao.TaskDao
import com.luma.focus.persistence.dao.HabitDao
import com.luma.focus.persistence.dao.RoomSessionDao
import com.luma.focus.persistence.entity.FocusSessionEntity
import com.luma.focus.persistence.entity.TaskEntity
import com.luma.focus.persistence.entity.HabitEntity
import com.luma.focus.persistence.entity.RoomSessionEntity

@Database(
    entities = [
        FocusSessionEntity::class,
        TaskEntity::class,
        HabitEntity::class,
        RoomSessionEntity::class
    ],
    version = 1
)
abstract class LumaDatabase : RoomDatabase() {
    abstract fun focusSessionDao(): FocusSessionDao
    abstract fun taskDao(): TaskDao
    abstract fun habitDao(): HabitDao
    abstract fun roomSessionDao(): RoomSessionDao
    
    companion object {
        private var instance: LumaDatabase? = null
        
        fun getInstance(context: Context): LumaDatabase {
            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    LumaDatabase::class.java,
                    "luma_database"
                ).build().also { instance = it }
            }
        }
    }
}
