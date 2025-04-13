pluginManagement {
    repositories {
        google()
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

rootProject.name = "WidgetExampleWithXML"
include(":app")
include(":core")
include(":core:common")
include(":core:data")
include(":core:domain")
include(":core:network")
include(":core:presentation")
include(":feature")
include(":feature:home")
include(":feature:splash")
include(":feature:widget")
include(":navigation-shared")
include(":core:localization")
