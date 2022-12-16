package com.kuraev.imgurclone.feature_auth.api.navigation

import com.kuraev.imgurclone.feature_api.FeatureApi

interface AuthNavFeatureApi : FeatureApi {

    fun onboardingRoute(): String
}