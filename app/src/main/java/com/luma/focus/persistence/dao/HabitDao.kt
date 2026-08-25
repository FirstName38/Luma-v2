package com.luma.focus.persistence.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.luma.focus.persistence.entity.HabitEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {
    @Insert
    suspend fun insert(habit: HabitEntity)
    
    @Update
    suspend fun update(habit: HabitEntity)
    
    @Delete
    suspend fun delete(habit: HabitEntity)
    
    @Query("SELECT * FROM habits WHERE id = :id")
    suspend fun getById(id: String): HabitEntity?
    
    @Query("SELECT * FROM habits ORDER BY startDate DESC")
    fun getAllHabits(): Flow<List<HabitEntity>>
}
