package com.example.domain.repositories

import com.example.domain.model.DirectoryDomain

interface DirectoryRepository {
    suspend fun insertContact(directoryDomain: DirectoryDomain)
    suspend fun deleteContact(contactId: Int)
    suspend fun updateContact(directoryDomain: DirectoryDomain) // новый метод
    suspend fun getAllContacts(): List<DirectoryDomain>
    suspend fun getContactById(contactId: Int): DirectoryDomain? // новый метод
}

