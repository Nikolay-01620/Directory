/*
package com.example

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.data.model.DirectoryData
import com.example.data.model.database.DirectoryDao

@Database(
    entities = [
        DirectoryData::class
    ],
    version = 3, exportSchema = false
)

abstract class AppDataBase : RoomDatabase() {

    abstract val directoryDao: DirectoryDao

    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            synchronized(this) {
                return instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "coin_app_db"
                )
                    .fallbackToDestructiveMigration()
                    .build().also {
                        instance = it
                    }
            }
        }
    }
}*/
