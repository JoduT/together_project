package com.example.projectwithulmas.SQL

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query("SELECT * FROM history")
    fun getAll(): Flow<List<History>>

    @Insert(entity = History::class)
    suspend fun insert(history: NewHistory)
}