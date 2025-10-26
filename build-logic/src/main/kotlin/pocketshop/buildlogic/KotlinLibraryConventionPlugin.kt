package pocketshop.buildlogic

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class KotlinLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("org.jetbrains.kotlin.jvm")
            pluginManager.apply("com.google.devtools.ksp")

            tasks.withType(KotlinCompile::class.java).configureEach {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_17)
                }
            }

            val libs = libs()
            dependencies {
                add("api", libs.findLibrary("javax.inject").get().get())
                add("implementation", libs.findLibrary("coroutines.core").get().get())
                add("compileOnly", libs.findLibrary("dagger").get().get())
                add("ksp", libs.findLibrary("dagger.compiler").get().get())
                add("testImplementation", libs.findLibrary("dagger").get().get())
                add("testImplementation", libs.findLibrary("junit").get().get())
                add("testImplementation", libs.findLibrary("mockk").get().get())
                add("testImplementation", libs.findLibrary("turbine").get().get())
            }
        }
    }
}
