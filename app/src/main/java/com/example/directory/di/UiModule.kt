package com.example.directory.di

import com.example.directory.ui.screens.main_screen.MainViewModel
import com.example.domain.repositories.DirectoryRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val uiModule = module {
    viewModel {
        MainViewModel(repository = get())
    }

}