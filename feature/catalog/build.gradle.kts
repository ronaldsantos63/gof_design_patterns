plugins {
    alias(libs.plugins.pocketshop.android.library)
    alias(libs.plugins.pocketshop.android.hilt)
    alias(libs.plugins.pocketshop.android.compose)
    alias(libs.plugins.pocketshop.android.testing)
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.designsystem)
    implementation(projects.core.data)
    implementation(projects.domain)

    // Paging 3 para a listagem (Iterator conceitual)
    implementation(libs.paging.runtime)
}
