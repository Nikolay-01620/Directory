package com.example.directory.di

import com.example.directory.ui.screens.add_contact_screen.AddContactViewModel
import com.example.directory.ui.screens.edit_screen.EditViewModel
import com.example.directory.ui.screens.main_screen.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { MainViewModel(directoryRepository = get()) }
    viewModel { AddContactViewModel(directoryRepository = get()) }
    viewModel { EditViewModel(directoryRepository = get()) }
}
