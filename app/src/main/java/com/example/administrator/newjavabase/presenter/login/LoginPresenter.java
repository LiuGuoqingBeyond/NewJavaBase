package com.example.administrator.newjavabase.presenter.login;

import android.content.Context;

import com.axl.android.frameworkbase.net.utils.ProgressSubscriber;
import com.example.administrator.newjavabase.contract.login.inter.LoginInterface;
import com.example.administrator.newjavabase.contract.login.listener.LoginListener;
import com.example.administrator.newjavabase.data.login.request.LoginReqModel;
import com.example.administrator.newjavabase.data.login.respons.LoginRespInfo;
import com.example.administrator.newjavabase.impl.login.LoginImp;
import com.example.administrator.newjavabase.model.constant.AppConfig;
import com.example.administrator.newjavabase.utils.app.AppUtils;
import com.example.administrator.newjavabase.utils.file.TransMapToBeanUtils;

import java.util.Map;
import java.util.TreeMap;

/**
 * User: LiuGuoqing
 * Data: 2018/11/16 0016.
 */

public class LoginPresenter implements LoginInterface {
    private final LoginListener loginListener;
    public LoginPresenter(LoginListener loginListener) {
        this.loginListener = loginListener;
    }
    @Override
    public void toLogin(Context context, String account, String password) {
        Map<String,String> map = new TreeMap<>();
        map.put("account",account);
        map.put("password",password);
        map.put("sign", AppUtils.getAppMd5String(map, AppConfig.APPMD5ENCRYKEY));

        LoginImp.INSTANCE.loginByPassward((LoginReqModel) TransMapToBeanUtils.mapToBean(map, LoginReqModel.class))
                .subscribe(new ProgressSubscriber<LoginRespInfo>(context) {
                    @Override
                    protected void _onNext(LoginRespInfo loginRespInfo) {
                        loginListener._onNext(loginRespInfo);
                    }

                    @Override
                    protected void _onError(String message) {
                        loginListener._onError(message);
                    }
        });
    }
}
