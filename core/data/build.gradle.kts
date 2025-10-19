plugins {
    alias(libs.plugins.pocketshop.android.library)
    alias(libs.plugins.pocketshop.android.hilt)
    alias(libs.plugins.pocketshop.android.testing)
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.domain)

    // Coroutines
    implementation(libs.coroutines.core)

    // Rede
    implementation(libs.retrofit)
    implementation(libs.okhttp)

    // Banco
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)
}
