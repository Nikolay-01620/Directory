package com.example.data.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.model.DirectoryData

@Dao
interface DirectoryDao {
    @Insert
    suspend fun insert(directory: DirectoryData)

    @Query("SELECT * FROM directory")
    suspend fun getAllContacts(): List<DirectoryData>

}
