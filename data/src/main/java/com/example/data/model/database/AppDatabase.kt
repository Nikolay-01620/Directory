package com.example.data.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.model.DirectoryData

@Database(entities = [DirectoryData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactDao(): DirectoryDao
}
