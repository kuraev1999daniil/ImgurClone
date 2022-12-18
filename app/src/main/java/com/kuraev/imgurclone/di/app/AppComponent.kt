package com.kuraev.imgurclone.di.app

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.internal.Preconditions
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    val context: Context

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance context: Context): AppComponent
    }

    companion object {

        @Volatile
        private var instance: AppComponent? = null

        fun get(): AppComponent =
            Preconditions.checkNotNull(
                instance,
                "AppComponent is not initialized yet. Call init first."
            )!!

        fun init(component: AppComponent) {
            instance = component
        }
    }
}