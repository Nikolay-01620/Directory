package com.example.directory.di

import com.example.data.repositiries.DirectoryRepositoryImpl
import com.example.domain.repositories.DirectoryRepository
import org.koin.dsl.module

val domainModule = module {

    factory<DirectoryRepository> {
        DirectoryRepositoryImpl(directoryDao = get())
    }
}