package com.kuraev.imgurclone.di.app

import dagger.Component
import dagger.internal.Preconditions
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    companion object {

        @Volatile
        private var instance: AppComponent? = null

        fun get(): AppComponent =
            Preconditions.checkNotNull(
                instance,
                "AppComponent is not initialized yet. Call init first."
            )!!

        fun init(component: AppComponent) {
            require(instance == null) { "AppComponent is already initialized." }
            instance = component
        }
    }
}