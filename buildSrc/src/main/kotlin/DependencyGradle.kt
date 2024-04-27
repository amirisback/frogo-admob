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

object DependencyGradle {

    const val KOTLIN_VERSION = Version.JetBrains.kotlin
    const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect:$KOTLIN_VERSION"
    const val COMPOSE_VERSION = Version.Androidx.composeCompiler

    const val FROGO_UI_VERSION = "2.0.3"
    const val FROGO_SDK_VERSION = "2.2.4"
    const val FROGO_CONSUME_API_VERSION = "2.5.4"
    const val FROGO_RECYCLER_VIEW_VERSION = "4.4.1"

    const val FROGO_UI = "com.github.frogobox:frogo-ui:$FROGO_UI_VERSION"
    const val FROGO_SDK = "com.github.frogobox:frogo-sdk:$FROGO_SDK_VERSION"
    const val FROGO_CONSUME_API = "com.github.frogobox:frogo-consume-api:$FROGO_CONSUME_API_VERSION"
    const val FROGO_RECYCLER_VIEW = "com.github.amirisback:frogo-recycler-view:$FROGO_RECYCLER_VIEW_VERSION"

    const val MODULE_LIB_FROGO_ADMOB = ":${ProjectSetting.MODULE_NAME_ADMOB}"
    const val MODULE_LIB_FROGO_AD = ":${ProjectSetting.MODULE_NAME_AD}"
    const val MODULE_LIB_FROGO_AD_CORE = ":${ProjectSetting.MODULE_NAME_AD_CORE}"
    const val MODULE_LIB_FROGO_UNITY_AD = ":${ProjectSetting.MODULE_NAME_UNITY_AD}"

}
