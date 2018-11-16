package com.example.administrator.newjavabase.model.api;

import com.example.administrator.newjavabase.data.login.request.LoginReqModel;
import com.example.administrator.newjavabase.data.login.respons.LoginRespInfo;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * User: LiuGuoqing
 * Data: 2018/11/15 0015.
 */

public interface ApiService {
    //登陆接口
    @POST(AppURLManager.REQ_LOGIN_PATH)
    Flowable<LoginRespInfo> appLogin(@Body LoginReqModel params);
}
