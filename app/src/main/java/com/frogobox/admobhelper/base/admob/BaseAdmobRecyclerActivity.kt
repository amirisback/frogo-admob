package com.frogobox.admobhelper.base.admob

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.frogobox.admobhelper.R
import com.google.android.gms.ads.AdView

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * ImplementationAdmob
 * Copyright (C) 29/11/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.admobhelper.base.admob
 *
 */
open class BaseAdmobRecyclerActivity : BaseAdmobActivity() {

    protected fun setupDetailActivity(title: String) {
        setTitle(title)
        val upArrow = ContextCompat.getDrawable(this, R.drawable.ic_toolbar_back_home)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(upArrow)
        supportActionBar?.setBackgroundDrawable(
            ColorDrawable(
                ContextCompat.getColor(
                    this,
                    R.color.colorBaseWhite
                )
            )
        )
    }

    protected val arrayRecyclerView = mutableListOf<Any>()

    override fun onResume() {
        for (item in arrayRecyclerView) {
            if (item is AdView) {
                val adView = item as AdView
                adView.resume()
            }
        }
        super.onResume()
    }

    override fun onPause() {
        for (item in arrayRecyclerView) {
            if (item is AdView) {
                val adView = item as AdView
                adView.pause()
            }
        }
        super.onPause()
    }

    override fun onDestroy() {
        for (item in arrayRecyclerView) {
            if (item is AdView) {
                val adView = item as AdView
                adView.destroy()
            }
        }
        super.onDestroy()
    }

}