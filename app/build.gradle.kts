plugins {
    alias(libs.plugins.pocketshop.android.application)
    alias(libs.plugins.pocketshop.android.hilt)
    alias(libs.plugins.pocketshop.android.compose)
}

android {
    namespace = "com.ronaldsantos.pocketshop"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.ronaldsantos.pocketshop"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.designsystem)
    implementation(projects.core.data)
    implementation(projects.domain)

    implementation(projects.feature.catalog)
    implementation(projects.feature.cart)
    implementation(projects.feature.auth)
    implementation(projects.feature.sync)
}
