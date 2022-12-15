import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.version
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

val PluginDependenciesSpec.androidApplicationPlugin: PluginDependencySpec
    get() = this.id("com.android.application")

val PluginDependenciesSpec.androidLibraryPlugin: PluginDependencySpec
    get() = this.id("com.android.library")

val PluginDependenciesSpec.kotlinAndroidPlugin: PluginDependencySpec
    get() = this.id("org.jetbrains.kotlin.android")

val PluginDependenciesSpec.kotlinKapt: PluginDependencySpec
    get() = this.id("org.jetbrains.kotlin.kapt")

val PluginDependenciesSpec.kotlinJvm: PluginDependencySpec
    get() = this.kotlin("jvm")

