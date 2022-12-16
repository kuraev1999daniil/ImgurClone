package com.kuraev.imgurclone.feature_auth.impl.di

import com.kuraev.imgurclone.core_injector.ComponentHolder
import com.kuraev.imgurclone.feature_auth.api.AuthDiFeatureApi

object AuthComponentHolder : ComponentHolder<AuthDiFeatureApi, AuthFeatureDependencies> {

    private var authComponentHolder: AuthComponent? = null

    override fun init(dependencies: AuthFeatureDependencies) {
        if (authComponentHolder == null) {
            synchronized(AuthComponentHolder::class.java) {
                if (authComponentHolder == null) {
                    authComponentHolder = AuthComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): AuthDiFeatureApi {
        checkNotNull(authComponentHolder)

        return authComponentHolder!!
    }

    override fun reset() {
        authComponentHolder = null
    }
}