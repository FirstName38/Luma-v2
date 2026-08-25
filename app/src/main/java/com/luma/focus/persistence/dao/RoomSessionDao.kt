package com.luma.focus.persistence.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.luma.focus.persistence.entity.RoomSessionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomSessionDao {
    @Insert
    suspend fun insert(session: RoomSessionEntity)
    
    @Update
    suspend fun update(session: RoomSessionEntity)
    
    @Delete
    suspend fun delete(session: RoomSessionEntity)
    
    @Query("SELECT * FROM room_sessions WHERE id = :id")
    suspend fun getById(id: String): RoomSessionEntity?
    
    @Query("SELECT * FROM room_sessions WHERE date = :date ORDER BY startTime DESC")
    fun getByDate(date: String): Flow<List<RoomSessionEntity>>
    
    @Query("SELECT * FROM room_sessions ORDER BY startTime DESC")
    fun getAllSessions(): Flow<List<RoomSessionEntity>>
}
