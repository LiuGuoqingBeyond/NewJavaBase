package com.example.administrator.newjavabase.ui.login.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.administrator.newjavabase.R
import com.whty.xzfpos.base.AppBaseActivity
import kotlinx.android.synthetic.main.activity_wel_come.*

class WelComeActivity : AppBaseActivity() {
    override fun getBundleExtras(extras: Bundle?) {
    }

    override fun getContentViewLayoutID(): Int {
        return R.layout.activity_wel_come
    }

    override fun initViewsAndEvents() {
        // 避免从桌面启动程序后，会重新实例化入口类的activity
        if (!this.isTaskRoot) { // 判断当前activity是不是所在任务栈的根
            var intent = intent
            if (intent != null) {
                if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && Intent.ACTION_MAIN == intent!!.action) {
                    finish()
                    return
                }
            }
        }

        tv_space.spacing = 10f
        tv_space.text = getString(R.string.welcome_use_app)
        Handler().postDelayed(Runnable() {
            openActivity(LoginActivity::class.java, true)
        }, 1500)
    }

    override fun getLoadingTargetView(): View? {
        return null
    }
}
