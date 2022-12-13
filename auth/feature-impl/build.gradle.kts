plugins {
    androidLibraryPlugin
    kotlinAndroidPlugin
    kotlinKapt
}

android {
    namespace = Namespaces.FEATURE_AUTH_IMPL_ID
    compileSdk = Versions.Sdk.compileSdk

    defaultConfig {
        minSdk = Versions.Sdk.minSdk
        targetSdk = Versions.Sdk.targetSdk

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.compiler
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Versions.Kotlin.jvmTarget
    }
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