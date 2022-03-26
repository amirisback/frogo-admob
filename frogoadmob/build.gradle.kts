plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    `maven-publish`
}

android {

    compileSdk = ProjectSetting.PROJECT_COMPILE_SDK

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
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    composeOptions {
        kotlinCompilerExtensionVersion = DependencyGradle.COMPOSE_VERSION
    }

    packagingOptions {
        resources {
            excludes += setOf("META-INF/AL2.0", "META-INF/LGPL2.1")
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }

}

dependencies {

    implementation(Androidx.appCompat)
    implementation(Androidx.Core.ktx)
    implementation(Androidx.constraintLayout)
    implementation(Androidx.Lifecycle.runtimeKtx)
    implementation(Androidx.Work.runtimeKtx)

    implementation(Androidx.Compose.ui)
    implementation(Androidx.Compose.material)
    implementation(Androidx.Compose.uiTooling)
    implementation(Androidx.Compose.activity)

    implementation(Ad.unityAds)
    implementation(Google.adMediationUnityAd)

    implementation(Google.gson)
    implementation(Google.material)
    implementation(Google.admob)
    implementation(Google.userMessagingPlatform)

    implementation(Square.Retrofit2.retrofit)
    implementation(Square.Retrofit2.converterGson)
    implementation(Square.Retrofit2.adapterRxJava3)
    implementation(Reactivex.rxJava3)
    implementation(Reactivex.rxAndroid3)

    implementation(Util.glide)

    implementation(Frogo.log(DependencyGradle.FROGO_LOG))
    implementation(Frogo.sdk(DependencyGradle.FROGO_SDK))
    implementation(Frogo.recyclerView(DependencyGradle.FROGO_RECYCLER_VIEW))

}

afterEvaluate {
    publishing {
        publications {

            // Creates a Maven publication called "release".
            register("release", MavenPublication::class) {

                // Applies the component for the release build variant.
                // NOTE : Delete this line code if you publish Native Java / Kotlin Library
                from(components["release"])

                // Library Package Name (Example : "com.frogobox.androidfirstlib")
                // NOTE : Different GroupId For Each Library / Module, So That Each Library Is Not Overwritten
                groupId = ProjectSetting.PROJECT_LIB_ID

                // Library Name / Module Name (Example : "androidfirstlib")
                // NOTE : Different ArtifactId For Each Library / Module, So That Each Library Is Not Overwritten
                artifactId = ProjectSetting.NAME_APK

                // Version Library Name (Example : "1.0.0")
                version = ProjectSetting.PROJECT_VERSION_NAME

            }
        }
    }
}