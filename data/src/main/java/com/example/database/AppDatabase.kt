package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Directory::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactDao(): DirectoryDao
}
