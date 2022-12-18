package com.kuraev.imgurclone.presentation.base

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kuraev.imgurclone.App
import com.kuraev.imgurclone.core_injector.di.base.vm.VmFactory
import com.kuraev.imgurclone.di.app.AppComponent
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseActivity<vm : ViewModel>(private val vmClass: KClass<vm>) : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: VmFactory

    @Suppress("MemberVisibilityCanBePrivate")
    protected val app: App by lazy { applicationContext as App }

    protected val appComponent: AppComponent = AppComponent.get()

    abstract fun buildDagger()

    protected lateinit var viewModel: vm

    override fun onCreate(savedInstanceState: Bundle?) {

        // This app draws behind the system bars, so we want to handle fitting system windows
        WindowCompat.setDecorFitsSystemWindows(window, false)

        window?.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)

        buildDagger()

        createVm()

        super.onCreate(savedInstanceState)
    }

    private fun createVm() {
        viewModel = ViewModelProvider(this, viewModelFactory)[vmClass.java]
    }
}