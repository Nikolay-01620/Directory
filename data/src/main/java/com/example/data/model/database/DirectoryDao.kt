package com.example.data.model.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.model.DirectoryData

@Dao
interface DirectoryDao {
    @Insert
    suspend fun insert(directory: DirectoryData)

    @Query("DELETE FROM directory WHERE id = :contactId")
    suspend fun delete(contactId: Int)

    @Update
    suspend fun update(directory: DirectoryData)

    @Query("SELECT * FROM directory WHERE id = :contactId")
    suspend fun getContactById(contactId: Int): DirectoryData?

    @Query("SELECT * FROM directory")
    suspend fun getAllContacts(): List<DirectoryData>
}
