plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    `maven-publish`
}

android {

    compileSdk = ProjectSetting.PROJECT_COMPILE_SDK
    namespace = ProjectSetting.PROJECT_LIB_ID_AD_CORE

    defaultConfig {
        minSdk = ProjectSetting.PROJECT_MIN_SDK
        targetSdk = ProjectSetting.PROJECT_TARGET_SDK

        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        consumerProguardFile("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        jvmToolchain {
            languageVersion.set(JavaLanguageVersion.of("17"))
        }
    }

}

dependencies {
    implementation(DependencyGradle.FROGO_SDK)
}

afterEvaluate {
    publishing {
        publications {

            repositories {
                maven {
                    name = ProjectSetting.MODULE_NAME_AD_CORE
                    url = uri(ProjectSetting.URI_PACKAGE_LIB)
                    credentials {
                        username = project.findProperty("gpr.user") as String? ?: ""
                        password = project.findProperty("gpr.key") as String? ?: ""
                    }
                }
            }

            // Creates a Maven publication called "release".
            register("release", MavenPublication::class) {

                // Applies the component for the release build variant.
                // NOTE : Delete this line code if you publish Native Java / Kotlin Library
                from(components["release"])

                // Library Package Name (Example : "com.frogobox.androidfirstlib")
                // NOTE : Different GroupId For Each Library / Module, So That Each Library Is Not Overwritten
                groupId = ProjectSetting.BASE_PROJECT_PACKAGE

                // Library Name / Module Name (Example : "androidfirstlib")
                // NOTE : Different ArtifactId For Each Library / Module, So That Each Library Is Not Overwritten
                artifactId = ProjectSetting.MODULE_NAME_AD_CORE

                // Version Library Name (Example : "1.0.0")
                version = ProjectSetting.PROJECT_VERSION_NAME

            }
        }
    }
}