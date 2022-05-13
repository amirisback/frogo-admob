import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {

    compileSdk = ProjectSetting.PROJECT_COMPILE_SDK
    namespace = ProjectSetting.PROJECT_APP_ID

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

        // Inject admob id for debug
        resValue("string", "admob_app_id", AdValue.debugAdmobAppId)
        resValue("string", "admob_banner", AdValue.debugAdmobBanner)
        resValue("string", "admob_interstitial", AdValue.debugAdmobInterstitial)
        resValue("string", "admob_interstitial_video", AdValue.debugAdmobInterstitialVideo)
        resValue("string", "admob_rewarded", AdValue.debugAdmobRewarded)
        resValue("string", "admob_rewarded_interstitial", AdValue.debugAdmobRewardedInterstitial)
        resValue("string", "admob_native_advanced", AdValue.debugAdmobNativeAdvanced)
        resValue("string", "admob_native_advanced_video", AdValue.debugAdmobNativeAdvancedVideo)

        resValue("string", "unity_ad_game_id", AdValue.debugUnityAdGameId)
        resValue("string", "unity_ad_interstitial", AdValue.debugUnityAdInterstitial)

    }

    signingConfigs {
        create("release") {
            // You need to specify either an absolute path or include the
            // keystore file in the same directory as the build.gradle file.
            // [PROJECT FOLDER NAME/app/[COPY YOUT KEY STORE] .jks in here
            storeFile = file(ProjectSetting.PLAYSTORE_STORE_FILE)
            storePassword = ProjectSetting.PLAYSTORE_STORE_PASSWORD
            keyAlias = ProjectSetting.PLAYSTORE_KEY_ALIAS
            keyPassword = ProjectSetting.PLAYSTORE_KEY_PASSWORD
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            // Generated Signed APK / AAB
            signingConfig = signingConfigs.getByName("release")

            // Inject app name for release
            resValue("string", "app_name", ProjectSetting.NAME_APP)

            // Inject admob id for release
            resValue("string", "admob_app_id", AdValue.releaseAdmobAppId)
            resValue("string", "admob_banner", AdValue.releaseAdmobBanner)
            resValue("string", "admob_interstitial", AdValue.releaseAdmobInterstitial)
            resValue("string", "admob_interstitial_video", AdValue.releaseAdmobInterstitialVideo)
            resValue("string", "admob_rewarded", AdValue.releaseAdmobRewarded)
            resValue("string", "admob_rewarded_interstitial", AdValue.releaseAdmobRewardedInterstitial)
            resValue("string", "admob_native_advanced", AdValue.releaseAdmobNativeAdvanced)
            resValue("string", "admob_native_advanced_video", AdValue.releaseAdmobNativeAdvancedVideo)

            resValue("string", "unity_ad_game_id", AdValue.releaseUnityAdGameId)
            resValue("string", "unity_ad_interstitial", AdValue.releaseUnityAdInterstitial)

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

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }

    composeOptions {
        kotlinCompilerExtensionVersion = DependencyGradle.COMPOSE_VERSION
    }

    packagingOptions {
        resources {
            excludes += setOf("/META-INF/{AL2.0,LGPL2.1}", "META-INF/AL2.0", "META-INF/LGPL2.1")
        }
    }

}

dependencies {
    implementation(project(DependencyGradle.FROGO_PATH_ADMOB))

    implementation(Androidx.Compose.ui)
    implementation(Androidx.Compose.material)
    implementation(Androidx.Compose.uiTooling)
    implementation(Androidx.Compose.activity)
    
    implementation(DependencyGradle.FROGO_UI)
    implementation(DependencyGradle.FROGO_SDK)
    implementation(DependencyGradle.FROGO_CONSUME_API)
    implementation(DependencyGradle.FROGO_RECYCLER_VIEW)
}