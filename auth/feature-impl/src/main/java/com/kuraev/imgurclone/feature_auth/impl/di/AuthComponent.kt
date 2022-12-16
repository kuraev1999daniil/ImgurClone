package com.kuraev.imgurclone.feature_auth.impl.di

import com.kuraev.imgurclone.feature_auth.api.AuthDiFeatureApi
import com.kuraev.imgurclone.feature_auth.impl.di.modules.AuthModule
import dagger.Component

@Component(dependencies = [AuthFeatureDependencies::class], modules = [AuthModule::class])
internal abstract class AuthComponent : AuthDiFeatureApi {

    companion object {

        fun initAndGet(authFeatureDependencies: AuthFeatureDependencies): AuthComponent =
            DaggerAuthComponent.builder()
                .authFeatureDependencies(authFeatureDependencies)
                .build()
    }
}