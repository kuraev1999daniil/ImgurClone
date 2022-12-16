plugins {
    androidLibraryPlugin
    kotlinAndroidPlugin
}

android {
    applyBaseComposeLibraryConfig(Namespaces.CORE_UI_ID)
}

dependencies {

    implementation(Libraries.Compose.ui)
    implementation(Libraries.Compose.material3)
}