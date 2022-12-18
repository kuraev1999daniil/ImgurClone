package com.kuraev.imgurclone.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.kuraev.imgurclone.core_ui.theme.ImgurCloneTheme
import com.kuraev.imgurclone.di.app.AppComponent
import com.kuraev.imgurclone.di.main.DaggerMainComponent
import com.kuraev.imgurclone.feature_api.FeatureApi
import com.kuraev.imgurclone.feature_auth.api.navigation.AuthNavFeatureApi
import com.kuraev.imgurclone.presentation.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity<MainVm>(MainVm::class) {

    @Inject
    lateinit var authNavigation: AuthNavFeatureApi

    override fun buildDagger() {
        DaggerMainComponent.builder()
            .appComponent(AppComponent.get())
            .build()
            .inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen(viewModel, authNavigation)
        }
    }
}

@Composable
private fun MainScreen(viewModel: MainVm, authNavigation: AuthNavFeatureApi) {
    ImgurCloneTheme {
        Box {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = authNavigation.onboardingRoute()
            ) {
                register(
                    authNavigation,
                    navController = navController
                )
            }
        }
    }
}

fun NavGraphBuilder.register(
    featureApi: FeatureApi,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    featureApi.registerGraph(
        navGraphBuilder = this,
        navController = navController,
        modifier = modifier
    )
}