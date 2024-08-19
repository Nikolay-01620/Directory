package com.example.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "directory")
data class Directory(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val phoneNumber: String,
)
