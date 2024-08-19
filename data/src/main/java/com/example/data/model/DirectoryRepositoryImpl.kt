package com.example.data.model

import com.example.database.DirectoryDao
import com.example.domain.model.DirectoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DirectoryRepositoryImpl(private val directoryDao: DirectoryDao) : DirectoryRepository {
    override suspend fun insertContact() {
        withContext(Dispatchers.IO) {
        }
    }

    override suspend fun updateContact() {
        withContext(Dispatchers.IO) {
        }
    }

    override suspend fun deleteContact() {
        withContext(Dispatchers.IO) {
        }
    }

    override suspend fun getAllContacts() {
        withContext(Dispatchers.IO) {
        }
    }

    override suspend fun getContactById() {
        withContext(Dispatchers.IO) {
        }
    }
}
