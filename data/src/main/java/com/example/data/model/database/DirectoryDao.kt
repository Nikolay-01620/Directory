package com.example.data.model.database

import androidx.room.Dao
import androidx.room.Insert
import com.example.data.model.DirectoryData

@Dao
interface DirectoryDao {
    @Insert
    suspend fun insert(directory: DirectoryData)

}
