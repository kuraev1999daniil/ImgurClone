plugins {
    androidApplicationPlugin
    kotlinAndroidPlugin
    kotlinKapt
}

android {
    namespace = Namespaces.APPLICATION_ID
    compileSdk = Versions.Sdk.compileSdk

    defaultConfig {
        applicationId = Namespaces.APPLICATION_ID
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

    buildFeatures {
        compose = true
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
    implementation(project(Modules.Feature.authImpl))

    implementation(Libraries.Core.coreKtx)
    implementation(Libraries.Core.activityCompose)
    implementation(Libraries.Core.lifecycleRuntimeKtx)

    implementation(Libraries.Compose.ui)
    implementation(Libraries.Compose.tooling)
    implementation(Libraries.Compose.toolingPreview)
    implementation(Libraries.Compose.material3)

    implementation(Libraries.Dagger.dagger)
    kapt(Libraries.Dagger.compiler)
}