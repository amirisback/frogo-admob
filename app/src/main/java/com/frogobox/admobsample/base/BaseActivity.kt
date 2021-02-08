package com.frogobox.admobsample.base

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.frogobox.admobsample.R
import com.frogobox.admob.core.admob.FrogoAdmobActivity

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * ImplementationAdmob
 * Copyright (C) 27/11/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.admobhelper.base
 *
 */
open class BaseActivity : FrogoAdmobActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupAdmob()
    }

    private fun setupAdmob(){
        setBasePublisherID(getString(R.string.admob_publisher_id))
        setBaseBannerAdUnitID(getString(R.string.admob_banner))
        setBaseInterstialAdUnitID(getString(R.string.admob_interstitial))
        setBaseRewardedAdUnitID(getString(R.string.admob_rewarded_video))
        setBaseAdmob()
    }

    protected fun setupCustomTitleToolbar(title: Int) {
        supportActionBar?.setTitle(title)
    }

    protected fun setupNoLimitStatBar() {
        val windows = window // in Activity's onCreate() for instance
        windows.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }

    protected fun setupChildFragment(frameId: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(frameId, fragment)
            commit()
        }
    }

    protected inline fun <reified ClassActivity> baseStartActivity() {
        this.startActivity(Intent(this, ClassActivity::class.java))
    }

    protected inline fun <reified ClassActivity, Model> baseStartActivity(
        extraKey: String,
        data: Model
    ) {
        val intent = Intent(this, ClassActivity::class.java)
        val extraData = BaseHelper().baseToJson(data)
        intent.putExtra(extraKey, extraData)
        this.startActivity(intent)
    }

    protected inline fun <reified Model> baseGetExtraData(extraKey: String): Model {
        val extraIntent = intent.getStringExtra(extraKey)
        val extraData = BaseHelper().baseFromJson<Model>(extraIntent)
        return extraData
    }

    protected fun checkExtra(extraKey: String): Boolean {
        return intent?.hasExtra(extraKey)!!
    }

    protected fun <Model> baseFragmentNewInstance(
        fragment: BaseFragment,
        argumentKey: String,
        extraDataResult: Model
    ) {
        fragment.baseNewInstance(argumentKey, extraDataResult)
    }


    protected fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    protected fun setupDetailActivity(title: String) {
        setTitle(title)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    protected fun setupEventEmptyView(view: View, isEmpty: Boolean) {
        if (isEmpty) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

    protected fun setupEventProgressView(view: View, progress: Boolean) {
        if (progress) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

}