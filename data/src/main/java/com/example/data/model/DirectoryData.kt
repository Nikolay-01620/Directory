package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "directory")
data class DirectoryData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val secondName: String,
    val phoneNumber: String,
    val photoUri: String?
)
