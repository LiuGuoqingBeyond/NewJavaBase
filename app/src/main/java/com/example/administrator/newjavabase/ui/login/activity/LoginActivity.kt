package com.example.administrator.newjavabase.ui.login.activity

import android.os.Bundle
import android.view.View
import com.example.administrator.newjavabase.R
import com.example.administrator.newjavabase.contract.login.listener.LoginListener
import com.example.administrator.newjavabase.data.login.respons.LoginRespInfo
import com.example.administrator.newjavabase.presenter.login.LoginPresenter
import com.example.administrator.newjavabase.ui.main.activity.MainActivity
import com.example.administrator.newjavabase.utils.app.PreferencesUtil
import com.example.administrator.newjavabase.utils.dialog.ToastUtils
import com.whty.xzfpos.base.AppBaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppBaseActivity(), LoginListener, View.OnClickListener {
    private var prefe: PreferencesUtil? = null
    private var mAccount = ""
    private var mPassword = ""
    private val loginInterface = LoginPresenter(this)
    override fun getBundleExtras(extras: Bundle?) {
    }

    override fun getContentViewLayoutID(): Int {
        return R.layout.activity_login
    }

    override fun initViewsAndEvents() {
        prefe = PreferencesUtil(mContext)
        btn_login.setOnClickListener(this)
        img_eyePassword.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view!!.id){
            R.id.img_eyePassword->{

            }
            R.id.btn_login->{
                getData()
//                if (isNull) {
                tv_error.visibility = View.GONE
                loginApp()
//                }
            }
        }
    }

    private fun loginApp() {
        loginInterface.toLogin(mContext,mAccount,mPassword)
    }

    override fun _onNext(loginRespInfo: LoginRespInfo?) {
        if (loginRespInfo!!.isOk) {
            ToastUtils.showLong(loginRespInfo!!.returnMsg)
            openActivity(MainActivity::class.java,true)
        }
    }

    override fun _onError(errorMsg: String?) {
        ToastUtils.showLong(errorMsg)
    }

    private fun getData() {
        mAccount = et_account!!.text.toString().trim()
        mPassword = et_password!!.text.toString()
    }

    override fun getLoadingTargetView(): View? {
        return null
    }
}
