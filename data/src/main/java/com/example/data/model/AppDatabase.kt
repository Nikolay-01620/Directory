package com.example.data.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DirectoryData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactDao(): DirectoryDao
}
