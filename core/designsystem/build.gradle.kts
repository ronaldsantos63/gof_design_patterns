plugins {
    alias(libs.plugins.pocketshop.android.library)
    alias(libs.plugins.pocketshop.android.compose)
    alias(libs.plugins.pocketshop.android.testing)
}

dependencies {
    implementation(projects.core.common)
}
