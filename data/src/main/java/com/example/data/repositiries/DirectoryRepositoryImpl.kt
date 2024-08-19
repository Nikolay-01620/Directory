package com.example.data.repositiries

import com.example.data.model.database.DirectoryDao
import com.example.domain.model.DirectoryDomain
import com.example.domain.repositories.DirectoryRepository
import com.example.utils.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DirectoryRepositoryImpl(private val directoryDao: DirectoryDao) : DirectoryRepository {
    override suspend fun insertContact(directoryDomain: DirectoryDomain) {
        return withContext(Dispatchers.IO) {
            directoryDao.insert(directoryDomain.toDomain())
        }
    }
}
