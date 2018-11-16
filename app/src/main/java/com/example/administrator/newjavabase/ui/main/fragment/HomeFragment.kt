package com.example.administrator.newjavabase.ui.main.fragment

import android.os.Bundle
import com.example.administrator.newjavabase.R
import com.whty.xzfpos.base.AppBaseBackFragment

/**
 * User: LiuGuoqing
 * Data: 2018/11/16 0016.
 */
class HomeFragment : AppBaseBackFragment() {
    override fun getContentViewLayoutID(): Int {
        return R.layout.home_layout
    }

    override fun getBundleExtras(extras: Bundle?) {
    }

    override fun initViewsAndEvents() {
    }
}