pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

// Ajuda nos imports de projects: :core:data, etc.
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "PocketShop"

// Inclui o build de convenções
includeBuild("build-logic")

include(":app")
include(":core:common")
include(":core:designsystem")
include(":core:data")
include(":domain")
include(":feature:catalog")
include(":feature:cart")
include(":feature:auth")
include(":feature:sync")
include(":feature:about") // Dynamic Feature Module
