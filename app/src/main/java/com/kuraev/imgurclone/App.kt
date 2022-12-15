package com.kuraev.imgurclone

import android.app.Application
import com.kuraev.imgurclone.di.app.AppComponent
import com.kuraev.imgurclone.di.app.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        AppComponent.init(DaggerAppComponent.builder().build())
    }
}