plugins {
    androidLibraryPlugin
    kotlinAndroidPlugin
}

android {
    applyBaseLibraryConfig(Namespaces.FEATURE_AUTH_API_ID)
}

dependencies {

    api(project(Modules.Feature.coreInjector))
}