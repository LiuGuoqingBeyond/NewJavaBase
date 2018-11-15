package com.whty.xzfpos.base

import android.os.Bundle
import butterknife.ButterKnife
import com.axl.android.frameworkbase.ui.BaseBackFragment
import com.axl.android.frameworkbase.view.statusbar.StatusBarCompat
import com.example.administrator.newjavabase.base.app.GlobalApp
import com.example.administrator.newjavabase.utils.publicutils.PreferencesUtil

/**
 * User: Axl_Jacobs(Axl.Jacobs@gmail.com)
 * Date: 2017/11/7
 * Time: 15:22
 */
open abstract class AppBaseBackFragment : BaseBackFragment() {
    protected val sp: PreferencesUtil by lazy {
        PreferencesUtil(context)
    }


    override fun onStart() {
        super.onStart()
        ButterKnife.bind(this, this.view!!)
        StatusBarCompat.translucentStatusBar(activity!!, true, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalApp.addActivity(activity)
    }

    override fun onBackPressed(): Boolean = false
}