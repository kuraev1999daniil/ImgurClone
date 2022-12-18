package com.kuraev.imgurclone.di.main

import com.kuraev.imgurclone.di.app.AppComponent
import com.kuraev.imgurclone.presentation.MainActivity
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [MainModule::class])
@ActivityScope
interface MainComponent {

    fun inject(mainActivity: MainActivity)
}