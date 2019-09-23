package br.com.cantinho.android_mvvm_clean_architecture.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

object AppInjection {

    fun init(application: Application) {
        startKoin {
            androidLogger()
            androidContext(application)
            modules(listOf(repositoryModule, viewModelModule))
        }
    }

}