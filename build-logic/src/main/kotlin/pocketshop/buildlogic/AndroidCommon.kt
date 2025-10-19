package pocketshop.buildlogic

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCommon() {
    extensions.configure(BaseExtension::class.java) {
        val libs = libs()
        compileSdkVersion(libs.findVersion("compileSdk").get().requiredVersion.toInt())
        defaultConfig {
            minSdk = libs.findVersion("minSdk").get().requiredVersion.toInt()
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            vectorDrawables.useSupportLibrary = true
        }
        compileOptions.apply {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
        testOptions.unitTests.isReturnDefaultValues = true
        packagingOptions.resources.excludes.addAll(listOf("META-INF/*"))

        dependencies {
            add("implementation", libs.findLibrary("androidx-core-ktx").get().get())
        }
    }
}
