object Versions {

    object Sdk {
        val minSdk = 21
        val targetSdk = 33
        val compileSdk = 33
    }

    object App {
        private val major = 1
        private val minor = 0
        private val revision = 0
        var build = 0

        val versionCode
            get() = major * 1000 + minor * 100 + revision * 10 + build
        val versionName
            get() = "${major}.${minor}.${revision}.${build}"
    }

    object Core {
        const val coreKtx = "1.9.0"
        const val lifecycleRuntimeKtx = "2.5.1"
        const val activityCompose = "1.6.1"
    }

    object Kotlin {
        const val jvmTarget = "1.8"
    }

    object Compose {
        const val ui = "1.3.1"
        const val compiler = "1.3.2"
        const val material3 = "1.0.1"
    }
}