package com.example.data.model

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface DirectoryDao {
    @Insert
    suspend fun insert(directory: DirectoryData)

}
