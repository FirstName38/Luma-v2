package com.luma.focus.persistence.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.luma.focus.persistence.entity.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert
    suspend fun insert(task: TaskEntity)
    
    @Update
    suspend fun update(task: TaskEntity)
    
    @Delete
    suspend fun delete(task: TaskEntity)
    
    @Query("SELECT * FROM tasks WHERE id = :id")
    suspend fun getById(id: String): TaskEntity?
    
    @Query("SELECT * FROM tasks WHERE date = :date ORDER BY priority DESC, deadline ASC")
    fun getByDate(date: String): Flow<List<TaskEntity>>
    
    @Query("SELECT * FROM tasks WHERE completed = 0 ORDER BY priority DESC, deadline ASC")
    fun getActiveTasks(): Flow<List<TaskEntity>>
    
    @Query("SELECT * FROM tasks ORDER BY date DESC")
    fun getAllTasks(): Flow<List<TaskEntity>>
}
