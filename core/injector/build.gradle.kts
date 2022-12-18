plugins {
    androidLibraryPlugin
    kotlinAndroidPlugin
    kotlinKapt
}

android {
    applyBaseComposeLibraryConfig(Namespaces.CORE_INJECTOR)
}

dependencies {

    implementation(Libraries.Compose.ui)

    implementation(Libraries.Navigation.navigation)

    implementation(Libraries.Dagger.dagger)
    kapt(Libraries.Dagger.compiler)
}