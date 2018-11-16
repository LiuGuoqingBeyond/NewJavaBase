package com.example.administrator.newjavabase.contract.login.listener;

import com.example.administrator.newjavabase.data.login.respons.LoginRespInfo;

/**
 * User: LiuGuoqing
 * Data: 2018/11/16 0016.
 */

public interface LoginListener {
    void _onNext(LoginRespInfo loginRespInfo);
    void _onError(String errorMsg);
}
