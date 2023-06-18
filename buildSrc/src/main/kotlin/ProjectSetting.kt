/**
 * Created by faisalamir on 19/09/21
 * FrogoRecyclerView
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.
 * All rights reserved
 *
 */

object ProjectSetting {

    const val NAME_APP = "Frogo Admob"
    val NAME_APK = NAME_APP.lowercase().replace(" ", "-")

    const val APP_DOMAIN = "com"
    const val APP_PLAY_CONSOLE = "frogobox"
    const val APP_NAME = "appadmob"
    val URI_PACKAGE_LIB = "https://maven.pkg.github.com/amirisback/${NAME_APK}"

    // ---------------------------------------------------------------------------------------------

    const val VERSION_MAJOR = 5
    const val VERSION_MINOR = 3
    const val VERSION_PATCH = 0

    // ---------------------------------------------------------------------------------------------

    const val LIBRARY_NAME_AD = "ad"
    const val LIBRARY_NAME_AD_CORE = "adcore"
    const val LIBRARY_NAME_ADMOB = "admob"
    const val LIBRARY_NAME_UNITY_AD = "unityad"
    const val LIBRARY_NAME_START_IO_AD = "startioad"

    // ---------------------------------------------------------------------------------------------

    const val MODULE_NAME_AD = "ad-general"
    const val MODULE_NAME_AD_CORE = "ad-core"
    const val MODULE_NAME_ADMOB = "ad-admob"
    const val MODULE_NAME_UNITY_AD = "ad-unityad"

    // ---------------------------------------------------------------------------------------------

    const val PROJECT_MIN_SDK = Version.Gradle.minSdk
    const val PROJECT_COMPILE_SDK = Version.Gradle.compileSdk
    const val PROJECT_TARGET_SDK = PROJECT_COMPILE_SDK

    // ---------------------------------------------------------------------------------------------
    const val BASE_PROJECT_PACKAGE = "$APP_DOMAIN.$APP_PLAY_CONSOLE"

    const val PROJECT_APP_ID = "$BASE_PROJECT_PACKAGE.$APP_NAME"
    const val PROJECT_LIB_ID_AD = "$BASE_PROJECT_PACKAGE.$LIBRARY_NAME_AD"
    const val PROJECT_LIB_ID_ADMOB = "$BASE_PROJECT_PACKAGE.$LIBRARY_NAME_ADMOB"
    const val PROJECT_LIB_ID_AD_CORE = "$BASE_PROJECT_PACKAGE.$LIBRARY_NAME_AD_CORE"

    const val PROJECT_LIB_ID_UNITY_AD = "$BASE_PROJECT_PACKAGE.$LIBRARY_NAME_UNITY_AD"
    const val PROJECT_LIB_ID_START_IO_AD = "$BASE_PROJECT_PACKAGE.$LIBRARY_NAME_START_IO_AD"

    const val PROJECT_VERSION_CODE = (VERSION_MAJOR * 100) + (VERSION_MINOR * 10) + (VERSION_PATCH * 1)
    const val PROJECT_VERSION_NAME = "$VERSION_MAJOR.$VERSION_MINOR.$VERSION_PATCH"

    // ---------------------------------------------------------------------------------------------

    // Key Store
    const val PLAYSTORE_STORE_FILE = "frogoboxmedia.jks"
    const val PLAYSTORE_STORE_PASSWORD = "amirisback"
    const val PLAYSTORE_KEY_ALIAS = "frogoisback"
    const val PLAYSTORE_KEY_PASSWORD = "amirisback"

    // ---------------------------------------------------------------------------------------------
}
