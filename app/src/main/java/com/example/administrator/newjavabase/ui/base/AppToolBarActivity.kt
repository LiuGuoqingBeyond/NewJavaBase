package com.whty.xzfpos.base

import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.axl.android.frameworkbase.view.statusbar.StatusBarCompat
import com.axl.android.frameworkbase.widget.BaseToolbar
import com.example.administrator.newjavabase.BuildConfig
import com.example.administrator.newjavabase.base.app.GlobalApp
import com.example.administrator.newjavabase.R
import com.umeng.analytics.MobclickAgent

/**
 * User: Axl_Jacobs(Axl.Jacobs@gmail.com)
 * Date: 2017/11/6
 * Time: 12:01
 */
abstract class AppToolBarActivity : AppBaseActivity() {

    protected val mToolbar: BaseToolbar by lazy {
        BaseToolbar(mContentView, this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mToolbar.setDefaultNavigation()
        initToolBar()

        StatusBarCompat.setStatusBarColor(this@AppToolBarActivity, ContextCompat.getColor(this@AppToolBarActivity, R.color.colorPrimary))

        GlobalApp.addActivity(this)
    }

    protected abstract fun initToolBar()

    override fun onResume() {
        super.onResume()
        if (BuildConfig.IS_OFFICIAL.toBoolean())
            MobclickAgent.onResume(this)
    }

    override fun onPause() {
        super.onPause()
        if (BuildConfig.IS_OFFICIAL.toBoolean())
            MobclickAgent.onPause(this)
    }
}