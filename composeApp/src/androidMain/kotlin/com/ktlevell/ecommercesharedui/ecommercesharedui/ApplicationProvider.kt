package com.ktlevell.ecommercesharedui.ecommercesharedui

import android.app.Application
import com.ktlevell.ecommercesharedui.ecommercesharedui.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class ApplicationProvider : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(this@ApplicationProvider)
        }
    }
}