package com.example.projectwithulmas.SQL

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [
    History::class
], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDao() : Dao
}