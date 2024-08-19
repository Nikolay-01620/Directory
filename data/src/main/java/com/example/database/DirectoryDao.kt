package com.example.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete

@Dao
interface DirectoryDao {
    @Insert
    suspend fun insert(): DirectoryData

}
