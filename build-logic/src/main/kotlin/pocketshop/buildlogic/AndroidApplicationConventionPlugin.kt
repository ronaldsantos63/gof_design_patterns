package pocketshop.buildlogic

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.application")
            pluginManager.apply("org.jetbrains.kotlin.android")
            configureAndroidCommon()

            extensions.getByType<AppExtension>().apply {
                val libs = libs()
                defaultConfig {
                    targetSdk = libs.findVersion("targetSdk").get().requiredVersion.toInt()
                }

                buildTypes.getByName("debug").isMinifyEnabled = false
                buildTypes.getByName("release").apply {
                    isMinifyEnabled = true
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }
        }
    }
}
