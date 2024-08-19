package com.example.domain.repositories

import com.example.domain.model.DirectoryDomain

interface DirectoryRepository {
    suspend fun insertContact(): DirectoryDomain

}
