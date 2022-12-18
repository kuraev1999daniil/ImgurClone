package com.kuraev.imgurclone.di.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kuraev.imgurclone.core_injector.di.base.vm.VmFactory
import com.kuraev.imgurclone.core_injector.di.base.vm.VmKey
import com.kuraev.imgurclone.feature_auth.api.navigation.AuthNavFeatureApi
import com.kuraev.imgurclone.feature_auth.impl.presentation.navigation.AuthNavFeatureImpl
import com.kuraev.imgurclone.presentation.MainVm
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MainModule {

    @Binds
    @ActivityScope
    fun bindVmFactory(factory: VmFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ActivityScope
    @VmKey(MainVm::class)
    fun bindMainVm(vm: MainVm): ViewModel

    @Binds
    @ActivityScope
    fun bindAuthNavFeature(authNavFeature: AuthNavFeatureImpl): AuthNavFeatureApi
}