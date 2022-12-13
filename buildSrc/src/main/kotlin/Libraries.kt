object Libraries {

    object Core {
        const val coreKtx = "androidx.core:core-ktx:${Versions.Core.coreKtx}"
        const val lifecycleRuntimeKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Core.lifecycleRuntimeKtx}"
        const val activityCompose =
            "androidx.activity:activity-compose:${Versions.Core.activityCompose}"
    }

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.Compose.ui}"
        const val tooling = "androidx.compose.ui:ui-tooling:${Versions.Compose.ui}"
        const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.Compose.ui}"
        const val material3 = "androidx.compose.material3:material3:${Versions.Compose.material3}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout-compose:${Versions.Compose.constraintLayout}"
    }

    object Dagger {
        const val dagger = "com.google.dagger:dagger:${Versions.Dagger.dagger}"
        const val compiler = "com.google.dagger:dagger-compiler:${Versions.Dagger.dagger}"
    }
}