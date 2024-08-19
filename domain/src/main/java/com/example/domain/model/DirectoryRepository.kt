package com.example.domain.model

interface DirectoryRepository {

    suspend fun insertContact()

    suspend fun updateContact()

    suspend fun deleteContact()

    suspend fun getAllContacts()

    suspend fun getContactById()
}
