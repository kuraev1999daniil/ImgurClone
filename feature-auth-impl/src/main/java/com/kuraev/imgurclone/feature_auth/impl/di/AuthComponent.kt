package com.kuraev.imgurclone.feature_auth.impl.di

import com.kuraev.imgurclone.feature_auth.api.AuthFeatureApi
import com.kuraev.imgurclone.feature_auth.impl.di.modules.AuthModule
import dagger.Component

@Component(dependencies = [AuthFeatureDependencies::class], modules = [AuthModule::class])
internal abstract class AuthComponent : AuthFeatureApi {

    companion object {

        fun initAndGet(authFeatureDependencies: AuthFeatureDependencies): AuthComponent =
            DaggerAuthComponent.builder()
                .authFeatureDependencies(authFeatureDependencies)
                .build()
    }
}