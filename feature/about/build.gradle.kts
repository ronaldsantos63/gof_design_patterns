plugins {
    alias(libs.plugins.pocketshop.android.dynamicfeature)
    alias(libs.plugins.pocketshop.android.compose)
    alias(libs.plugins.pocketshop.android.testing)
}

dependencies {
    implementation(projects.app) // dynamic feature depende do app base
    implementation(projects.core.common)
    implementation(projects.core.designsystem)
}
