plugins {
    alias(libs.plugins.pocketshop.android.library)
    alias(libs.plugins.pocketshop.android.hilt)
    alias(libs.plugins.pocketshop.android.testing)
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.data)
    implementation(projects.domain)

    // WorkManager para usar nos pipelines (Template Method)
    implementation(libs.androidx.work.runtime.ktx)
}
