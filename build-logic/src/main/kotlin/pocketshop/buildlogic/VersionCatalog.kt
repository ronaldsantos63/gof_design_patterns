package pocketshop.buildlogic

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension

internal fun Project.libs(): VersionCatalog =
    extensions.getByType(VersionCatalogsExtension::class.java).named("libs")

