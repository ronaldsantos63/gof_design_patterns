package pocketshop.buildlogic

import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

@Suppress("unused")
class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.library")
            pluginManager.apply("org.jetbrains.kotlin.android")
            configureAndroidCommon()

            extensions.configure<LibraryExtension> {
                if (namespace == null) {
                    namespace = "com.ronaldsantos.pocketshop.feature." + path.replace(":", ".").trim('.')
                }
                buildFeatures {
                    buildConfig = true
                }
            }
        }
    }
}
