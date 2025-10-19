package pocketshop.buildlogic

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class HiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply("com.google.dagger.hilt.android")
        pluginManager.apply("com.google.devtools.ksp")

        val libs = libs()
        dependencies {
            add("implementation", libs.findLibrary("hilt.android").get().get())
            add("ksp", libs.findLibrary("hilt.compiler").get().get())
        }
    }
}
