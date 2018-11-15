package com.whty.xzfpos.base

import butterknife.ButterKnife
import com.axl.android.frameworkbase.ui.BaseFragment
import com.example.administrator.newjavabase.utils.publicutils.PreferencesUtil
import com.google.gson.Gson

/**
 * User: Axl_Jacobs(Axl.Jacobs@gmail.com)
 * Date: 2017/11/7
 * Time: 15:22
 */
open abstract class AppBaseFragment : BaseFragment() {
    protected val sp: PreferencesUtil by lazy {
        PreferencesUtil(context)
    }

    protected val mGson: Gson by lazy {
        Gson()
    }

    override fun onStart() {
        super.onStart()
        ButterKnife.bind(this, this.view!!)
    }

}