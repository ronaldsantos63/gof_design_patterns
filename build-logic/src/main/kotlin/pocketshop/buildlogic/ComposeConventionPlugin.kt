package pocketshop.buildlogic

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class ComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.withId("com.android.application") {
                extensions.getByType<ApplicationExtension>().apply {
                    buildFeatures.compose = true
                    composeOptions.kotlinCompilerExtensionVersion = "1.5.15"
                }
            }
            plugins.withId("com.android.library") {
                extensions.getByType<LibraryExtension>().apply {
                    buildFeatures.compose = true
                    composeOptions.kotlinCompilerExtensionVersion = "1.5.15"
                }
            }

            val libs = libs()
            dependencies {
                add("implementation", platform(libs.findLibrary("androidx-compose-bom").get().get()))
                add("implementation", libs.findLibrary("androidx-compose-ui").get().get())
                add("implementation", libs.findLibrary("androidx-compose-material3").get().get())
                add("implementation", libs.findLibrary("androidx-activity-compose").get().get())
                add("implementation", libs.findLibrary("androidx-lifecycle-runtime-compose").get().get())
                add("implementation", libs.findLibrary("androidx-compose-navigation").get().get())
                add("implementation", libs.findLibrary("androidx-hilt-navigation-compose").get().get())
                add("androidTestImplementation", libs.findLibrary("androidx-compose-ui-test-junit4").get().get())
                add("debugImplementation", libs.findLibrary("androidx-compose-ui-tooling").get().get())
                add("debugImplementation", libs.findLibrary("androidx-compose-ui-test-manifest").get().get())
                add("implementation", libs.findLibrary("androidx-compose-ui-tooling-preview").get().get())
            }
        }
    }
}
