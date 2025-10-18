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

rootProject.name = "Design Patterns"
include(":app")
include(":core:common")
include(":core:designsystem")
include(":core:data")
include(":domain")
include(":feature:catalog")
include(":feature:cart")
include(":feature:auth")
include(":feature:sync")
include(":feature:about")
