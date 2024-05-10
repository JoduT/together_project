package com.example.projectwithulmas.SQL

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class NewHistory(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int? = null,
    @ColumnInfo(name = "number")
    val number: Int,
    @ColumnInfo(name = "text")
    val text: String
)