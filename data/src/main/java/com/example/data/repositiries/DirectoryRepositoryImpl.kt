package com.example.data.repositiries

import com.example.data.model.database.DirectoryDao
import com.example.domain.model.DirectoryDomain
import com.example.domain.repositories.DirectoryRepository
import com.example.utils.toData
import com.example.utils.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class DirectoryRepositoryImpl(private val directoryDao: DirectoryDao) : DirectoryRepository {
    override suspend fun insertContact(directoryDomain: DirectoryDomain) {
        return withContext(Dispatchers.IO) {
            directoryDao.insert(directoryDomain.toData())
        }
    }

    override suspend fun getAllContacts(): List<DirectoryDomain> {
        return withContext(Dispatchers.IO) {
            directoryDao.getAllContacts().map { it.toDomain() }
        }
    }

    override suspend fun getContactById(contactId: Int): DirectoryDomain? {
        return withContext(Dispatchers.IO) {
            directoryDao.getContactById(contactId)?.toDomain()
        }
    }

    override suspend fun updateContact(directoryDomain: DirectoryDomain) {
        return withContext(Dispatchers.IO) {
            directoryDao.update(directoryDomain.toData())
        }
    }
}
