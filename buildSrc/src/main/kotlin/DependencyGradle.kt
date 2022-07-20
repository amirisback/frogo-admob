/*
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
    const val COMPOSE_VERSION = Version.Androidx.compose

    const val FROGO_UI_VERSION = "1.0.8"
    const val FROGO_SDK_VERSION = "2.0.4"
    const val FROGO_CONSUME_API_VERSION = "2.3.7"
    const val FROGO_RECYCLER_VIEW_VERSION = "4.2.3"

    const val FROGO_UI = "com.github.frogobox:frogo-ui:$FROGO_UI_VERSION"
    const val FROGO_SDK = "com.github.frogobox:frogo-sdk:$FROGO_SDK_VERSION"
    const val FROGO_CONSUME_API = "com.github.frogobox:frogo-consume-api:$FROGO_CONSUME_API_VERSION"
    const val FROGO_RECYCLER_VIEW = "com.github.amirisback:frogo-recycler-view:$FROGO_RECYCLER_VIEW_VERSION"

    const val MODULE_LIB_FROGO_ADMOB = ":frogoadmob"

    const val MODULE_LIB_FROGO_AD = ":frogoad"
    const val MODULE_LIB_FROGO_AD_CORE = ":frogoadcore"
    const val MODULE_LIB_FROGO_START_IO_AD = ":frogostartioad"
    const val MODULE_LIB_FROGO_UNITY_AD = ":frogounityad"

}
