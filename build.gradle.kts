// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.android.dynamic.feature) apply false
}

// Garante versão de JavaPoet no classpath de plugins (DataBinding traz 1.10.0)
buildscript {
    configurations.classpath {
        resolutionStrategy {
            force(libs.javapoet)
        }
    }
}

tasks.register("ci") {
    group = "verification"
    description = "Build + Test de todos os módulos"
    dependsOn(":app:assembleDebug", "test")
}
