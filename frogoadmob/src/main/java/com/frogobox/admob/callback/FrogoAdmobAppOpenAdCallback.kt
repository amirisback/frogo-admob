package com.frogobox.admob.callback

/**
 * Created by Faisal Amir on 24/10/22
 * -----------------------------------------
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) Frogobox ID / amirisback
 * All rights reserved
 */


/**
 * Interface definition for a callback to be invoked when an app open ad is complete (i.e.
 * dismissed or fails to show).
 */
interface FrogoAdmobAppOpenAdCallback {
    fun onAdDismissed(tag: String, message: String)

    fun onAdShowed(tag: String, message: String)
}