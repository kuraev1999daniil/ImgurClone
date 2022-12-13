@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        maven { url = uri("https://plugins.gradle.org/m2/") }
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ImgurClone"

include(":app")
include(":core:ui")
include(":core:injector")
include(":auth:feature-api")
include(":auth:feature-impl")