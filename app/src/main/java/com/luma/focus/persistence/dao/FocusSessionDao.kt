package com.luma.focus.persistence.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.luma.focus.persistence.entity.FocusSessionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FocusSessionDao {
    @Insert
    suspend fun insert(session: FocusSessionEntity)
    
    @Update
    suspend fun update(session: FocusSessionEntity)
    
    @Delete
    suspend fun delete(session: FocusSessionEntity)
    
    @Query("SELECT * FROM focus_sessions WHERE id = :id")
    suspend fun getById(id: String): FocusSessionEntity?
    
    @Query("SELECT * FROM focus_sessions WHERE date = :date ORDER BY startTime DESC")
    fun getByDate(date: String): Flow<List<FocusSessionEntity>>
    
    @Query("SELECT * FROM focus_sessions ORDER BY startTime DESC")
    fun getAllSessions(): Flow<List<FocusSessionEntity>>
    
    @Query("SELECT * FROM focus_sessions WHERE taskId = :taskId ORDER BY startTime DESC")
    fun getByTaskId(taskId: String): Flow<List<FocusSessionEntity>>
}
