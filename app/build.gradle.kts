plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("kotlin-android")
}

android {

    // Declaration admob id for release
    val releaseAdmobPublisherId = ""
    val releaseAdmobBanner = ""
    val releaseAdmobInterstitial = ""
    val releaseAdmobInterstitialVideo = ""
    val releaseAdmobRewarded = ""
    val releaseAdmobRewardedInterstitial = ""
    val releaseAdmobNativeAdvanced = ""
    val releaseAdmobNativeAdvancedVideo = ""

    compileSdk = ProjectSetting.PROJECT_COMPILE_SDK

    defaultConfig {
        applicationId = ProjectSetting.PROJECT_APP_ID
        minSdk = ProjectSetting.PROJECT_MIN_SDK
        targetSdk = ProjectSetting.PROJECT_TARGET_SDK
        versionCode = ProjectSetting.PROJECT_VERSION_CODE
        versionName = ProjectSetting.PROJECT_VERSION_NAME

        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Naming APK // AAB
        setProperty("archivesBaseName", "${ProjectSetting.NAME_APK}(${versionName})")

        // Inject app name for debug
        resValue("string", "app_name", ProjectSetting.NAME_APP)

        // Declaration admob id for debug
        val debugAdmobPublisherId = "ca-app-pub-3940256099942544~3347511713"
        val debugAdmobBanner = "ca-app-pub-3940256099942544/6300978111"
        val debugAdmobInterstitial = "ca-app-pub-3940256099942544/1033173712"
        val debugAdmobInterstitialVideo = "ca-app-pub-3940256099942544/8691691433"
        val debugAdmobRewarded = "ca-app-pub-3940256099942544/5224354917"
        val debugAdmobRewardedInterstitial = "ca-app-pub-3940256099942544/5354046379"
        val debugAdmobNativeAdvanced = "ca-app-pub-3940256099942544/2247696110"
        val debugAdmobNativeAdvancedVideo = "ca-app-pub-3940256099942544/1044960115"

        // Inject admob id for debug
        resValue("string", "admob_publisher_id", debugAdmobPublisherId)
        resValue("string", "admob_banner", debugAdmobBanner)
        resValue("string", "admob_interstitial", debugAdmobInterstitial)
        resValue("string", "admob_interstitial_video", debugAdmobInterstitialVideo)
        resValue("string", "admob_rewarded", debugAdmobRewarded)
        resValue("string", "admob_rewarded_interstitial", debugAdmobRewardedInterstitial)
        resValue("string", "admob_native_advanced", debugAdmobNativeAdvanced)
        resValue("string", "admob_native_advanced_video", debugAdmobNativeAdvancedVideo)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            // Inject app name for release
            resValue("string", "app_name", ProjectSetting.NAME_APP)

            // Inject admob id for release
            resValue("string", "admob_publisher_id", releaseAdmobPublisherId)
            resValue("string", "admob_banner", releaseAdmobBanner)
            resValue("string", "admob_interstitial", releaseAdmobInterstitial)
            resValue("string", "admob_interstitial_video", releaseAdmobInterstitialVideo)
            resValue("string", "admob_rewarded", releaseAdmobRewarded)
            resValue("string", "admob_rewarded_interstitial", releaseAdmobRewardedInterstitial)
            resValue("string", "admob_native_advanced", releaseAdmobNativeAdvanced)
            resValue("string", "admob_native_advanced_video", releaseAdmobNativeAdvancedVideo)

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
        kotlinCompilerExtensionVersion = Dependency.COMPOSE_VERSION
        kotlinCompilerVersion = Dependency.KOTLIN_VERSION
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
            useIR = true
        }
    }

    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }

}

dependencies {

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Dependency.KOTLIN_VERSION}")

    implementation(project(":frogoadmob"))

    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    implementation("androidx.compose.ui:ui:${Dependency.COMPOSE_VERSION}")
    implementation("androidx.compose.material:material:${Dependency.COMPOSE_VERSION}")
    implementation("androidx.compose.ui:ui-tooling-preview:${Dependency.COMPOSE_VERSION}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.3.1")
    
    implementation("com.google.code.gson:gson:2.8.8")
    implementation("com.google.android.material:material:1.4.0")
    implementation("com.google.android.gms:play-services-ads:20.3.0")

    implementation("com.github.bumptech.glide:glide:4.12.0")

    implementation("com.github.amirisback:frogo-log:2.0.4")
    implementation("com.github.amirisback:frogo-recycler-view:3.8.8")

    implementation("com.github.frogobox:frogo-consume-api:1.0.5")
    implementation("com.github.frogobox:frogo-android-ui-kit:1.0.4")

    kapt("com.github.bumptech.glide:compiler:4.11.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Dependency.COMPOSE_VERSION}")
    debugImplementation("androidx.compose.ui:ui-tooling:${Dependency.COMPOSE_VERSION}")
}
