import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.version
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

val PluginDependenciesSpec.androidApplicationPlugin: PluginDependencySpec
    get() = this.id("com.android.application") version (Versions.Gradle.buildToolsVersion)

val PluginDependenciesSpec.androidLibraryPlugin: PluginDependencySpec
    get() = this.id("com.android.library") version (Versions.Gradle.buildToolsVersion)

val PluginDependenciesSpec.kotlinAndroidPlugin: PluginDependencySpec
    get() = this.id("org.jetbrains.kotlin.android") version (Versions.Gradle.kotlinGradlePlugin)

val PluginDependenciesSpec.kotlinKapt: PluginDependencySpec
    get() = this.id("org.jetbrains.kotlin.kapt") version (Versions.Gradle.kotlinGradlePlugin)

val PluginDependenciesSpec.kotlinJvm: PluginDependencySpec
    get() = this.kotlin("jvm") version (Versions.Gradle.kotlinGradlePlugin)

