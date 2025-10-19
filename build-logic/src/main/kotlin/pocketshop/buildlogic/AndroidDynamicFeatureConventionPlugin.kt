package pocketshop.buildlogic

import com.android.build.api.dsl.DynamicFeatureExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidDynamicFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.dynamic-feature")
            pluginManager.apply("org.jetbrains.kotlin.android")
            configureAndroidCommon()

            val ext = extensions.getByType<DynamicFeatureExtension>()
            if (ext.namespace == null) {
                val defaultNs = "com.ronaldsantos.pocketshop.feature." + name.substringAfter(":")
                ext.namespace = defaultNs
            }
        }
    }
}
