package pocketshop.buildlogic

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class TestingConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        val libs = libs()
        dependencies {
            add("testImplementation", libs.findLibrary("junit").get().get())
            add("testImplementation", libs.findLibrary("mockk").get().get())
            add("testImplementation", libs.findLibrary("turbine").get().get())
            add("androidTestImplementation", libs.findLibrary("androidx-junit").get().get())
            add("androidTestImplementation", libs.findLibrary("androidx-test-core").get().get())
            add("androidTestImplementation", libs.findLibrary("androidx-espresso-core").get().get())
        }
    }
}
