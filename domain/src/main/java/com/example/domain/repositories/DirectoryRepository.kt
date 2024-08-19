package com.example.domain.repositories

import com.example.domain.model.DirectoryDomain

interface DirectoryRepository {
    suspend fun insertContact(directoryDomain: DirectoryDomain)
    suspend fun getAllContacts(): List<DirectoryDomain>

}
