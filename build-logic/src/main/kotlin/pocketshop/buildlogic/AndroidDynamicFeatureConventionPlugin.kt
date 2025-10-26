package pocketshop.buildlogic

import com.android.build.api.dsl.DynamicFeatureExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidDynamicFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.dynamic-feature")
            pluginManager.apply("org.jetbrains.kotlin.android")
            configureAndroidCommon()

            extensions.configure<DynamicFeatureExtension> {
                if (namespace == null) {
                    namespace = "com.ronaldsantos.pocketshop.feature." + name.substringAfterLast(":")
                }
            }
        }
    }
}
