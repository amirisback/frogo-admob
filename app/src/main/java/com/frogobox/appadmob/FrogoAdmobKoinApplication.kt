package com.frogobox.appadmob

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import com.frogobox.admob.callback.FrogoAdmobAppOpenAdCallback
import com.frogobox.admob.core.FrogoAppOpenAdManager
import com.google.android.gms.ads.MobileAds

/**
 * Created by Faisal Amir on 24/10/22
 * -----------------------------------------
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) Frogobox ID / amirisback
 * All rights reserved
 */


open class FrogoAdmobKoinApplication : FrogoKoinApplication(),
    Application.ActivityLifecycleCallbacks, LifecycleObserver {

    companion object {
        const val LOG_TAG = "FrogoAdmobApplication"
    }

    private lateinit var appOpenAdManager: FrogoAppOpenAdManager
    private var currentActivity: Activity? = null

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this)

        MobileAds.initialize(this) {}
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
        appOpenAdManager = FrogoAppOpenAdManager()
    }

    /** ActivityLifecycleCallback methods. */
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}

    override fun onActivityStarted(activity: Activity) {
        // An ad activity is started when an ad is showing, which could be AdActivity class from Google
        // SDK or another activity class implemented by a third party mediation partner. Updating the
        // currentActivity only when an ad is not showing will ensure it is not an ad activity, but the
        // one that shows the ad.
        if (!appOpenAdManager.isShowingAd) {
            currentActivity = activity
        }
    }

    override fun onActivityResumed(activity: Activity) {}

    override fun onActivityPaused(activity: Activity) {}

    override fun onActivityStopped(activity: Activity) {}

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

    override fun onActivityDestroyed(activity: Activity) {}

    open fun getAdOpenAppUnitId(context: Context?): String {
        return ""
    }

    /** LifecycleObserver method that shows the app open ad when the app moves to foreground. */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onMoveToForeground() {
        // Show the ad (if available) when the app moves to foreground.
        Log.d(LOG_TAG, "onMoveToForeground")
        Log.d(LOG_TAG, "AmirIsBack")
        currentActivity?.let {
            appOpenAdManager.showAdIfAvailable(
                it,
                getAdOpenAppUnitId(currentActivity)
            )
        }
    }

    /**
     * Shows an app open ad.
     *
     * @param activity the activity that shows the app open ad
     * @param callback the listener to be notified when an app open ad is complete
     */
    fun showAdIfAvailable(
        activity: Activity,
        appOpenAdUnitId: String,
        callback: FrogoAdmobAppOpenAdCallback
    ) {
        // We wrap the showAdIfAvailable to enforce that other classes only interact with MyApplication
        // class.
        appOpenAdManager.showAdIfAvailable(activity, appOpenAdUnitId, callback)
    }

}