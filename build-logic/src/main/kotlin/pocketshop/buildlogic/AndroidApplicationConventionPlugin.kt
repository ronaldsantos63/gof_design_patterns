package pocketshop.buildlogic

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

@Suppress("unused")
class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.application")
            pluginManager.apply("org.jetbrains.kotlin.android")
            configureAndroidCommon()

            extensions.configure<ApplicationExtension> {
                defaultConfig {
                    targetSdk = libs().findVersion("targetSdk").get().requiredVersion.toInt()
                }
                buildTypes.named("debug").configure { isMinifyEnabled = false }
                buildTypes.named("release").configure {
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
