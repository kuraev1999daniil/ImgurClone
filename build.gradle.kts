// Root build.gradle.kts

buildscript {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        flatDir { dirs("../libs") }
    }

    val kotlinGradlePlugin = "1.7.20"
    val buildToolsVersion = "7.3.0"

    dependencies {
        classpath("com.android.tools.build:gradle:$buildToolsVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinGradlePlugin")
    }
}