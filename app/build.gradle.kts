plugins {
    id(Plugins.ANDROID_APPLICATION_PLUGIN)
    applyCommonPlugins()
    id(Plugins.KOTLIN_KAPT)
}

android {
    namespace = APPLICATION_ID
    compileSdk = Versions.Sdk.compileSdk

    defaultConfig {
        applicationId = APPLICATION_ID
        minSdk = Versions.Sdk.minSdk
        targetSdk = Versions.Sdk.targetSdk
        versionCode = Versions.App.versionCode
        versionName = Versions.App.versionName

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = Versions.Kotlin.jvmTarget
    }

    buildFeatures {
        compose = true
        aidl = false
        buildConfig = false
        renderScript = false
        shaders = false
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.compiler
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Libraries.Core.coreKtx)
    implementation(Libraries.Core.activityCompose)
    implementation(Libraries.Core.lifecycleRuntimeKtx)

    implementation(Libraries.Compose.ui)
    implementation(Libraries.Compose.uiPreview)
    implementation(Libraries.Compose.material3)
}