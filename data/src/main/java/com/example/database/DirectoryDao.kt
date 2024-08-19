package com.example.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete

@Dao
interface DirectoryDao {
    @Insert
    suspend fun insert(directory: Directory)

    @Update
    suspend fun update(directory: Directory)

    @Delete
    suspend fun delete(directory: Directory)

    @Query("SELECT * FROM directory")
    suspend fun getAllContacts(): List<Directory>

    @Query("SELECT * FROM directory WHERE id = :id")
    suspend fun getContactById(id: Int): Directory?
}
