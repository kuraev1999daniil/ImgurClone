plugins {
    androidLibraryPlugin
    kotlinAndroidPlugin
}

android {
    applyBaseComposeLibraryConfig(Namespaces.CORE_FEATURE_API)
}

dependencies {

    implementation(Libraries.Navigation.navigation)
}