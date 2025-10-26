package pocketshop.buildlogic

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.DynamicFeatureExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCommon()  {
    val libs = libs()

    fun configureBase(ext: Any) {
        when (ext) {
            is ApplicationExtension -> {
                ext.apply {
                    compileSdk = libs.findVersion("compileSdk").get().requiredVersion.toInt()
                    defaultConfig {
                        minSdk = libs.findVersion("minSdk").get().requiredVersion.toInt()
                        targetSdk = libs.findVersion("targetSdk").get().requiredVersion.toInt()
                        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                        vectorDrawables.useSupportLibrary = true
                    }
                    compileOptions {
                        sourceCompatibility = JavaVersion.VERSION_17
                        targetCompatibility = JavaVersion.VERSION_17
                    }
                    testOptions.unitTests.isReturnDefaultValues = true
                    packaging.resources.excludes.add("META-INF/*")
                }
            }
            is LibraryExtension -> {
                ext.apply {
                    compileSdk = libs.findVersion("compileSdk").get().requiredVersion.toInt()
                    defaultConfig {
                        minSdk = libs.findVersion("minSdk").get().requiredVersion.toInt()
                        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                        consumerProguardFiles("consumer-rules.pro")
                    }
                    compileOptions {
                        sourceCompatibility = JavaVersion.VERSION_17
                        targetCompatibility = JavaVersion.VERSION_17
                    }
                    testOptions.unitTests.isReturnDefaultValues = true
                    packaging.resources.excludes.add("META-INF/*")
                }
            }
            is DynamicFeatureExtension -> {
                ext.apply {
                    compileSdk = libs.findVersion("compileSdk").get().requiredVersion.toInt()
                    defaultConfig {
                        minSdk = libs.findVersion("minSdk").get().requiredVersion.toInt()
                        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    }
                    compileOptions {
                        sourceCompatibility = JavaVersion.VERSION_17
                        targetCompatibility = JavaVersion.VERSION_17
                    }
                    testOptions.unitTests.isReturnDefaultValues = true
                    packaging.resources.excludes.add("META-INF/*")
                }
            }
        }
    }

    plugins.withId("com.android.application") {
        extensions.configure<ApplicationExtension> { configureBase(this) }
    }
    plugins.withId("com.android.library") {
        extensions.configure<LibraryExtension> { configureBase(this) }
    }
    plugins.withId("com.android.dynamic-feature") {
        extensions.configure<DynamicFeatureExtension> { configureBase(this) }
    }
    dependencies {
        add("implementation", libs.findLibrary("androidx.core.ktx").get().get())
        add("implementation", libs.findLibrary("androidx.lifecycle.runtime-ktx").get().get())
    }
}
