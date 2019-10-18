package com.inside.developed.zimadtestproject.core

import android.app.Application
import com.inside.developed.zimadtestproject.core.di.netModule
import com.inside.developed.zimadtestproject.core.di.repoModule
import com.inside.developed.zimadtestproject.core.di.viesModule
import org.koin.android.ext.android.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        val modules = listOf(repoModule, netModule, viesModule)
        startKoin(this, modules)
    }
}