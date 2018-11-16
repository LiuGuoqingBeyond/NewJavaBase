package com.example.administrator.newjavabase.impl.login

import com.axl.android.frameworkbase.net.HttpEngine
import com.axl.android.frameworkbase.net.utils.RxSchedulersHelper
import com.example.administrator.newjavabase.data.login.request.LoginReqModel
import com.example.administrator.newjavabase.data.login.respons.LoginRespInfo
import com.example.administrator.newjavabase.model.api.ApiService
import io.reactivex.Flowable

/**
 * User: LiuGuoqing
 * Data: 2018/11/16 0016.
 */
object LoginImp {
    fun loginByPassward(loginReqModel: LoginReqModel): Flowable<LoginRespInfo> {
        return Flowable.just("")
                .switchMap {
                    HttpEngine.getInstance().createServices(ApiService::class.java)
                            .appLogin(loginReqModel)
                            .compose(RxSchedulersHelper.io_main())
                }
    }
}