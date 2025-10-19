plugins {
    `kotlin-dsl`
}

java {
    toolchain { languageVersion.set(JavaLanguageVersion.of(17)) }
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    // Consome artefatos dos plugins via version catalog
    implementation(libs.android.gradle.plugin)
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.hilt.gradle.plugin)
    implementation(libs.ksp.gradle.plugin)
}

// Registra os plugins de convenção expostos por este included build
gradlePlugin {
    plugins {
        register("pocketshop.android.application") {
            id = "pocketshop.android.application"
            implementationClass = "pocketshop.buildlogic.AndroidApplicationConventionPlugin"
        }
        register("pocketshop.android.library") {
            id = "pocketshop.android.library"
            implementationClass = "pocketshop.buildlogic.AndroidLibraryConventionPlugin"
        }
        register("pocketshop.android.dynamicfeature") {
            id = "pocketshop.android.dynamicfeature"
            implementationClass = "pocketshop.buildlogic.AndroidDynamicFeatureConventionPlugin"
        }
        register("pocketshop.android.compose") {
            id = "pocketshop.android.compose"
            implementationClass = "pocketshop.buildlogic.ComposeConventionPlugin"
        }
        register("pocketshop.android.hilt") {
            id = "pocketshop.android.hilt"
            implementationClass = "pocketshop.buildlogic.HiltConventionPlugin"
        }
        register("pocketshop.kotlin.library") {
            id = "pocketshop.kotlin.library"
            implementationClass = "pocketshop.buildlogic.KotlinLibraryConventionPlugin"
        }
        register("pocketshop.android.testing") {
            id = "pocketshop.android.testing"
            implementationClass = "pocketshop.buildlogic.TestingConventionPlugin"
        }
    }
}
