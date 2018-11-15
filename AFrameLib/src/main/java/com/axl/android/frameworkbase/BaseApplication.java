package com.axl.android.frameworkbase;

import android.content.Context;
import android.support.multidex.MultiDexApplication;
import android.text.TextUtils;

import com.axl.android.frameworkbase.utils.Constant;
import com.axl.android.frameworkbase.utils.PreferencesUtil;
import com.orhanobut.logger.Logger;

/**
 * User: Axl_Jacobs(Axl.Jacobs@gmail.com)
 * Date: 2017/10/26
 * Time: 15:41
 */

public class BaseApplication extends MultiDexApplication {

    private static Context sAppContext;
    private static String sCacheDir;

    // 当前系统是否设置为英文系统
    private static boolean englishSystem = false;
    // FIXME: 2017/12/8 Lgq当选择一语言时，其它两个语言为false
    private static boolean chineseSystem = false;
    private static boolean chineseTwSystem = false;

    private static PreferencesUtil preferencesUtil;
    // 是否为商户帐号
    private static boolean merchantAccount = true;

    //是否为收营员
    private static boolean cashierAccount = true;

    //是否为代理
    private static boolean agentAccount = true;

    // 是否做撤销交易
    public static boolean finishRevokeTrade = false;

    //是否为手机号登录
    public static boolean phoneLogin = true;

    //是都为添加收银员成功返回
    public static boolean addCashier = false;

    String index = "";
    private String loginIndex = "";

    @Override
    public void onCreate() {
        super.onCreate();
        sAppContext = getApplicationContext();
        if (getApplicationContext().getExternalCacheDir() != null && ExistSDCard()) {
            sCacheDir = getApplicationContext().getExternalCacheDir().toString();
        } else {
            sCacheDir = getApplicationContext().getCacheDir().toString();
        }

        preferencesUtil = new PreferencesUtil(sAppContext);
        index = preferencesUtil.readPrefs(Constant.MERCHANT_ACCOUNT);
        try {
            if(!TextUtils.isEmpty(index)) {
                switch (Integer.parseInt(index)) {
                    case 0:
                        BaseApplication.merchantAccount = true;
                        break;
                    case 1:
                        BaseApplication.merchantAccount = false;
                        break;
                }
            } else {
                BaseApplication.merchantAccount = true;
            }
        } catch (Exception e) {
            Logger.e(e.getMessage());
        }
        Logger.e("merchantAccount:" + merchantAccount);

        loginIndex = preferencesUtil.readPrefs(Constant.PHONE_LOGIN);
        try {
            if(!TextUtils.isEmpty(loginIndex)) {
                switch (Integer.parseInt(loginIndex)) {
                    case 0:
                        BaseApplication.phoneLogin = true;
                        break;
                    case 1:
                        BaseApplication.phoneLogin = false;
                        break;
                }
            } else {
                BaseApplication.phoneLogin = true;
            }
        } catch (Exception e) {
            Logger.e(e.getMessage());
        }
    }

    public static String getAppCacheDir() {
        return sCacheDir;
    }


    public static Context getAppContext() {
        return sAppContext;
    }

    private boolean ExistSDCard() {
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
    }

    public static void setEnglishSystem(boolean englishSystem) {
        BaseApplication.englishSystem = englishSystem;
    }
    public static boolean isEnglishSystem() {
        return englishSystem;
    }

    public static void setChineseSystem(boolean chineseSystem) {
        BaseApplication.chineseSystem = chineseSystem;
    }
    public static boolean isChineseSystem() {
        return chineseSystem;
    }

    public static void setChineseTwSystem(boolean chineseTwSystem) {
        BaseApplication.chineseTwSystem = chineseTwSystem;
    }
    public static boolean isChineseTwSystem() {
        return chineseTwSystem;
    }

    public static boolean isMerchantAccount() {
        return merchantAccount;
    }
    public static boolean isCashierAccount(){
        return cashierAccount;
    }
    public static boolean isAgentAccount(){
        return agentAccount;
    }

    public static void setMerchantAccount(int index) {
        switch (index) {
            case 0:
                BaseApplication.merchantAccount = true;
                BaseApplication.cashierAccount = false;
                BaseApplication.agentAccount = false;
                break;
            case 1:
                BaseApplication.merchantAccount = false;
                BaseApplication.cashierAccount = true;
                BaseApplication.agentAccount = false;
                break;
            case 2:
                BaseApplication.merchantAccount = false;
                BaseApplication.cashierAccount = false;
                BaseApplication.agentAccount = true;
                break;
        }
        preferencesUtil.writePrefs(Constant.MERCHANT_ACCOUNT,"" + index);
    }

    public static boolean isPhoneLogin(){
        return phoneLogin;
    }

    public static void setPhoneLogin(int index){
        switch (index){
            case 0:
                BaseApplication.phoneLogin = true;
                break;
            case 1:
                BaseApplication.phoneLogin = false;
                break;
        }
        preferencesUtil.writePrefs(Constant.PHONE_LOGIN,""+index);
    }

    public static boolean isAddCashier() {
        return addCashier;
    }

    public static void setAddCashier(boolean addCashier) {
        BaseApplication.addCashier = addCashier;
    }
}
