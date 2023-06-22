package com.traveling.presentation.wiget

import android.app.Application
import com.traveling.data.PreferenceManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MaruApplication: Application() {
    companion object {
        lateinit var prefs: PreferenceManager
    }

    override fun onCreate() {
        super.onCreate()
        prefs = PreferenceManager(applicationContext)
    }
}