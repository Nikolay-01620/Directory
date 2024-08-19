package com.example.data.di

import com.example.data.model.AppDatabase
import com.example.data.model.DatabaseProvider
import com.example.data.model.DirectoryDao
import com.example.data.repositiries.DirectoryRepositoryImpl
import com.example.domain.repositories.DirectoryRepository
import org.koin.dsl.module


val dataModule = module {

    // Провайдер для базы данных
    single { DatabaseProvider.getDatabase(get()) }

    // Провайдер для DAO
    single { get<AppDatabase>().contactDao() }

    // Провайдер для репозитория
    single<DirectoryRepository> { DirectoryRepositoryImpl(get()) }
}
