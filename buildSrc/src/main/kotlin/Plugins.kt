import Plugins.KOTLIN_ANDROID_PLUGIN
import org.gradle.plugin.use.PluginDependenciesSpec

object Plugins {

    const val ANDROID_APPLICATION_PLUGIN = "com.android.application"
    const val KOTLIN_ANDROID_PLUGIN = "org.jetbrains.kotlin.android"
    const val KOTLIN_KAPT = "org.jetbrains.kotlin.kapt"
}

fun PluginDependenciesSpec.applyCommonPlugins() {
    id(KOTLIN_ANDROID_PLUGIN)
}