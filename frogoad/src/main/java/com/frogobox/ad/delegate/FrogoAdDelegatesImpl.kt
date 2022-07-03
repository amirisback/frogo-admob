package com.frogobox.ad.delegate

import androidx.appcompat.app.AppCompatActivity
import com.frogobox.ad.callback.FrogoAdInterstitialCallback
import com.frogobox.admob.callback.FrogoAdmobInterstitialCallback
import com.frogobox.admob.delegate.AdmobDelegates
import com.frogobox.admob.delegate.AdmobDelegatesImpl
import com.frogobox.sdk.ext.showLogD
import com.frogobox.startioad.delegate.StartIoDelegates
import com.frogobox.startioad.delegate.StartIoDelegatesImpl
import com.frogobox.unityad.callback.FrogoUnityAdInterstitialCallback
import com.frogobox.unityad.delegate.UnityAdDelegates
import com.frogobox.unityad.delegate.UnityAdDelegatesImpl

/*
 * Created by faisalamir on 22/03/22
 * FrogoAdmob
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2022 Frogobox Media Inc.      
 * All rights reserved
 *
 */


class FrogoAdDelegatesImpl : FrogoAdDelegates,
    AdmobDelegates by AdmobDelegatesImpl(),
    UnityAdDelegates by UnityAdDelegatesImpl(),
    StartIoDelegates by StartIoDelegatesImpl() {

    override fun setupFrogoAdDelegates(activity: AppCompatActivity) {
        showLogD<FrogoAdDelegatesImpl>("===== Setup FrogoAdDelegates =====")
        showLogD<FrogoAdDelegatesImpl>("activity: $activity")
        showLogD<FrogoAdDelegatesImpl>("Injection Child Activity")
        setupAdmobDelegates(activity)
        setupUnityAdDelegates(activity)
        setupStartIoDelegates(activity)
    }

    override fun showAdmobXUnityAdInterstitial(
        admobInterstitialId: String,
        unityInterstitialId: String,
        callback: FrogoAdInterstitialCallback
    ) {

        if (admobInterstitialId == "") {
            showUnityAdInterstitial(unityInterstitialId, object : FrogoUnityAdInterstitialCallback {
                override fun onClicked(tag: String, message: String) {
                    callback.onClicked(tag, message)
                }

                override fun onShowAdRequestProgress(tag: String, message: String) {
                    callback.onShowAdRequestProgress(tag, message)
                }

                override fun onHideAdRequestProgress(tag: String, message: String) {
                    callback.onHideAdRequestProgress(tag, message)
                }

                override fun onAdDismissed(tag: String, message: String) {
                    callback.onAdDismissed(tag, message)
                }

                override fun onAdFailed(tag: String, errorMessage: String) {
                    callback.onAdFailed(tag, errorMessage)
                }

                override fun onAdLoaded(tag: String, message: String) {
                    callback.onAdLoaded(tag, message)
                }

                override fun onAdShowed(tag: String, message: String) {
                    callback.onAdShowed(tag, message)
                }
            })
        } else {
            showAdInterstitial(admobInterstitialId, object : FrogoAdmobInterstitialCallback {
                override fun onShowAdRequestProgress(tag: String, message: String) {
                    callback.onShowAdRequestProgress(tag, message)
                }

                override fun onHideAdRequestProgress(tag: String, message: String) {
                    callback.onHideAdRequestProgress(tag, message)
                }

                override fun onAdDismissed(tag: String, message: String) {
                    callback.onAdDismissed(tag, message)
                }

                override fun onAdFailed(tag: String, errorMessage: String) {
                    if (unityInterstitialId == "") {
                        callback.onAdFailed(tag, errorMessage)
                    } else {
                        showUnityAdInterstitial(unityInterstitialId,
                            object : FrogoUnityAdInterstitialCallback {
                                override fun onClicked(tag: String, message: String) {
                                    callback.onClicked(tag, message)
                                }

                                override fun onShowAdRequestProgress(tag: String, message: String) {
                                    callback.onShowAdRequestProgress(tag, message)
                                }

                                override fun onHideAdRequestProgress(tag: String, message: String) {
                                    callback.onHideAdRequestProgress(tag, message)
                                }

                                override fun onAdDismissed(tag: String, message: String) {
                                    callback.onAdDismissed(tag, message)
                                }

                                override fun onAdFailed(tag: String, errorMessage: String) {
                                    callback.onAdFailed(tag, errorMessage)
                                }

                                override fun onAdLoaded(tag: String, message: String) {
                                    callback.onAdLoaded(tag, message)
                                }

                                override fun onAdShowed(tag: String, message: String) {
                                    callback.onAdShowed(tag, message)
                                }
                            })
                    }
                }

                override fun onAdLoaded(tag: String, message: String) {
                    callback.onAdLoaded(tag, message)
                }

                override fun onAdShowed(tag: String, message: String) {
                    callback.onAdShowed(tag, message)
                }
            })
        }


    }

    // Mixed Ads Unity >> Admob
    override fun showUnityXAdmobAdInterstitial(
        admobInterstitialId: String,
        unityInterstitialId: String,
        callback: FrogoAdInterstitialCallback
    ) {

        if (unityInterstitialId == "") {
            showAdInterstitial(admobInterstitialId,
                object : FrogoAdmobInterstitialCallback {
                    override fun onShowAdRequestProgress(tag: String, message: String) {
                        callback.onShowAdRequestProgress(tag, message)
                    }

                    override fun onHideAdRequestProgress(tag: String, message: String) {
                        callback.onHideAdRequestProgress(tag, message)
                    }

                    override fun onAdDismissed(tag: String, message: String) {
                        callback.onAdDismissed(tag, message)
                    }

                    override fun onAdFailed(tag: String, errorMessage: String) {
                        callback.onAdFailed(tag, errorMessage)
                    }

                    override fun onAdLoaded(tag: String, message: String) {
                        callback.onAdLoaded(tag, message)
                    }

                    override fun onAdShowed(tag: String, message: String) {
                        callback.onAdShowed(tag, message)
                    }
                })
        }

        showUnityAdInterstitial(unityInterstitialId, object : FrogoUnityAdInterstitialCallback {
            override fun onAdDismissed(tag: String, message: String) {
                callback.onAdDismissed(tag, message)
            }

            override fun onAdFailed(tag: String, errorMessage: String) {
                if (admobInterstitialId == "") {
                    callback.onAdFailed(tag, errorMessage)
                } else {
                    showAdInterstitial(admobInterstitialId,
                        object : FrogoAdmobInterstitialCallback {
                            override fun onShowAdRequestProgress(tag: String, message: String) {
                                callback.onShowAdRequestProgress(tag, message)
                            }

                            override fun onHideAdRequestProgress(tag: String, message: String) {
                                callback.onHideAdRequestProgress(tag, message)
                            }

                            override fun onAdDismissed(tag: String, message: String) {
                                callback.onAdDismissed(tag, message)
                            }

                            override fun onAdFailed(tag: String, errorMessage: String) {
                                callback.onAdFailed(tag, errorMessage)
                            }

                            override fun onAdLoaded(tag: String, message: String) {
                                callback.onAdLoaded(tag, message)
                            }

                            override fun onAdShowed(tag: String, message: String) {
                                callback.onAdShowed(tag, message)
                            }
                        })
                }
            }

            override fun onAdLoaded(tag: String, message: String) {
                callback.onAdLoaded(tag, message)
            }

            override fun onAdShowed(tag: String, message: String) {
                callback.onAdShowed(tag, message)
            }

            override fun onClicked(tag: String, message: String) {
                callback.onClicked(tag, message)
            }

            override fun onShowAdRequestProgress(tag: String, message: String) {
                callback.onShowAdRequestProgress(tag, message)
            }

            override fun onHideAdRequestProgress(tag: String, message: String) {
                callback.onHideAdRequestProgress(tag, message)
            }
        })
    }
}