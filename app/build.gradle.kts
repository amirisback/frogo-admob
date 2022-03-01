plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {

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

        // Inject admob id for debug
        resValue("string", "admob_publisher_id", AdmobValue.debugAdmobPublisherId)
        resValue("string", "admob_banner", AdmobValue.debugAdmobBanner)
        resValue("string", "admob_interstitial", AdmobValue.debugAdmobInterstitial)
        resValue("string", "admob_interstitial_video", AdmobValue.debugAdmobInterstitialVideo)
        resValue("string", "admob_rewarded", AdmobValue.debugAdmobRewarded)
        resValue("string", "admob_rewarded_interstitial", AdmobValue.debugAdmobRewardedInterstitial)
        resValue("string", "admob_native_advanced", AdmobValue.debugAdmobNativeAdvanced)
        resValue("string", "admob_native_advanced_video", AdmobValue.debugAdmobNativeAdvancedVideo)
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
            resValue("string", "admob_publisher_id", AdmobValue.releaseAdmobPublisherId)
            resValue("string", "admob_banner", AdmobValue.releaseAdmobBanner)
            resValue("string", "admob_interstitial", AdmobValue.releaseAdmobInterstitial)
            resValue("string", "admob_interstitial_video", AdmobValue.releaseAdmobInterstitialVideo)
            resValue("string", "admob_rewarded", AdmobValue.releaseAdmobRewarded)
            resValue("string", "admob_rewarded_interstitial", AdmobValue.releaseAdmobRewardedInterstitial)
            resValue("string", "admob_native_advanced", AdmobValue.releaseAdmobNativeAdvanced)
            resValue("string", "admob_native_advanced_video", AdmobValue.releaseAdmobNativeAdvancedVideo)

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
    }

    packagingOptions {
        resources {
            excludes += setOf("/META-INF/{AL2.0,LGPL2.1}", "META-INF/AL2.0", "META-INF/LGPL2.1")
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }

}

dependencies {

    implementation(project(":frogoadmob"))

    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    implementation("androidx.compose.ui:ui:${Dependency.COMPOSE_VERSION}")
    implementation("androidx.compose.material:material:${Dependency.COMPOSE_VERSION}")
    implementation("androidx.compose.ui:ui-tooling-preview:${Dependency.COMPOSE_VERSION}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")

    implementation("androidx.work:work-runtime-ktx:2.7.1")

    implementation("androidx.activity:activity-compose:1.4.0")
    
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("com.google.android.material:material:1.5.0")
    implementation("com.google.android.gms:play-services-ads:20.6.0")

    implementation("com.github.bumptech.glide:glide:4.12.0")

    implementation("com.github.amirisback:frogo-log:2.0.8")
    implementation("com.github.amirisback:frogo-recycler-view:4.0.4")

    implementation("com.github.frogobox:frogo-consume-api:2.0.0")
    implementation("com.github.frogobox:frogo-ui:0.0.1-beta03")

    kapt("com.github.bumptech.glide:compiler:4.12.0")

}
