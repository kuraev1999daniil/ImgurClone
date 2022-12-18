package com.kuraev.imgurclone.di.app

import com.kuraev.imgurclone.feature_auth.api.AuthDiFeatureApi
import com.kuraev.imgurclone.feature_auth.impl.di.AuthComponentHolder
import com.kuraev.imgurclone.feature_auth.impl.di.AuthFeatureDependencies
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface AppModule {

    companion object {

        @Singleton
        @Provides
        fun provideAuthFeatureDependencies(): AuthFeatureDependencies =
            object : AuthFeatureDependencies {}

        @Provides
        fun provideAuthFeature(dependencies: AuthFeatureDependencies): AuthDiFeatureApi {
            AuthComponentHolder.init(dependencies)
            return AuthComponentHolder.get()
        }
    }
}