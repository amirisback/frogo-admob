pluginManagement {
    repositories {
        gradlePluginPortal()
        google{
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        maven("https://jitpack.io")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

rootProject.name = "FrogoAdmob"
include(
    ":app",
    ":ad-general",
    ":ad-admob",
    ":ad-core",
    ":ad-unityad"
)