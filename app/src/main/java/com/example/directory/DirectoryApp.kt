package com.example.directory

import android.app.Application
import com.example.data.di.dataModule
import com.example.directory.di.domainModule
import com.example.directory.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DirectoryApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DirectoryApp)
            modules(
                domainModule, uiModule, dataModule
            )
        }
    }
}