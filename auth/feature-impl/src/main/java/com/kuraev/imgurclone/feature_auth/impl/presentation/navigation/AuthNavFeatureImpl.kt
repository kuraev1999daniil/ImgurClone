package com.kuraev.imgurclone.feature_auth.impl.presentation.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.kuraev.imgurclone.feature_auth.api.navigation.AuthNavFeatureApi
import com.kuraev.imgurclone.feature_auth.impl.presentation.screens.OnboardingScreen

class AuthNavFeatureImpl : AuthNavFeatureApi {

    private val onboardingRoute = "onboardingRoute"

    override fun onboardingRoute(): String = onboardingRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.apply {
            composable(onboardingRoute) {
                OnboardingScreen()
            }
        }
    }
}