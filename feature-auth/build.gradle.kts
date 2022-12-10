plugins {
    androidLibraryPlugin
    kotlinAndroidPlugin
    kotlinKapt
}

android {
    namespace = "com.kuraev.imgurclone.feature_auth"
    compileSdk = 32

    defaultConfig {
        minSdk = 23
        targetSdk = 32

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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

}