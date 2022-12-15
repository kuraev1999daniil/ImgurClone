plugins {
    androidLibraryPlugin
    kotlinAndroidPlugin
    kotlinKapt
}

android {
    applyBaseComposeLibraryConfig(Namespaces.FEATURE_AUTH_IMPL_ID)
}

dependencies {

    implementation(project(Modules.Feature.authApi))

    implementation(Libraries.Core.coreKtx)
    implementation(Libraries.Core.activityCompose)
    implementation(Libraries.Core.lifecycleRuntimeKtx)

    implementation(Libraries.Compose.ui)
    implementation(Libraries.Compose.tooling)
    implementation(Libraries.Compose.toolingPreview)
    implementation(Libraries.Compose.material3)
    implementation(Libraries.Compose.constraintLayout)

    implementation(Libraries.Dagger.dagger)
    kapt(Libraries.Dagger.compiler)
}