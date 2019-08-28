package com.jlapp.roomexample

import android.app.Application
import com.facebook.stetho.Stetho
import com.jlapp.roomexample.di.dbModule
import com.jlapp.roomexample.di.repositoryModule
import com.jlapp.roomexample.di.uiModule
import com.jlapp.roomexample.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }

        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@MyApp)
            modules(
                listOf(
                    viewModelModule,
                    uiModule,
                    dbModule,
                    repositoryModule
                )
            )
        }
    }
}