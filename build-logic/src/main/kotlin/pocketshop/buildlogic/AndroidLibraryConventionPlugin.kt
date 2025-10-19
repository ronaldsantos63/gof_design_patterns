package pocketshop.buildlogic

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.library")
            pluginManager.apply("org.jetbrains.kotlin.android")
            configureAndroidCommon()

            val ext = extensions.getByType<LibraryExtension>()
            val defaultNs = "com.ronaldsantos.pocketshop.feature." + path.replace(":", ".").trim('.')
            if (ext.namespace == null) {
                ext.namespace = defaultNs
            }
            ext.buildFeatures.buildConfig = true
        }
    }
}
