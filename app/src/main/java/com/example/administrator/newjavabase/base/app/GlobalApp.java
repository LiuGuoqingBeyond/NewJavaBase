package com.example.administrator.newjavabase.base.app;

import android.app.Activity;
import android.support.multidex.MultiDex;

import com.axl.android.frameworkbase.BaseApplication;
import com.axl.android.frameworkbase.net.HttpEngine;
import com.example.administrator.newjavabase.BuildConfig;
import com.example.administrator.newjavabase.model.constant.AppConfig;
import com.example.administrator.newjavabase.utils.exception.CrashHandler;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.analytics.MobclickAgent;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * @project：agentpos
 * @author：- octopus on 2018/9/6 12:09
 * @email：zhanghuan@xinguodu.com
 */
public class GlobalApp extends BaseApplication {

    private static GlobalApp sInstance;
//    private RefWatcher mRefWatcher;

    private static List<Activity> listActivity = null;

    @Override
    public void onCreate() {
        super.onCreate();

        MultiDex.install(this);//
        sInstance = this;
        x.Ext.init(sInstance);

        HttpEngine.init(BuildConfig.BASEURL);
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });

        /*if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis. release模式下不引用
            return;
        }
        mRefWatcher = LeakCanary.install(this);*/

        if (Boolean.valueOf(BuildConfig.IS_OFFICIAL)) {
            MobclickAgent.startWithConfigure(new MobclickAgent.UMAnalyticsConfig(this,
                    AppConfig.UMENG_APPID, "officialdom", MobclickAgent.EScenarioType.E_UM_NORMAL));

            MobclickAgent.enableEncrypt(BuildConfig.DEBUG);
        }
        // 在这里为应用设置异常处理程序，然后我们的程序才能捕获未处理的异常
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);

        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(this);
        strategy.setAppVersion(BuildConfig.VERSION_NAME);

        CrashReport.initCrashReport(getApplicationContext(), AppConfig.BUGLY_APPID, false, strategy);
    }

    /**
     * 添加Activity 实体
     *
     * @param activity
     */
    public static void addActivity(Activity activity) {
        if(null == listActivity) {
            listActivity = new ArrayList<Activity>();
        }
        listActivity.add(activity);
    }

    /**
     * 清除所有Activity 实体
     */
    public static void removeAllActivity() {
        if(null == listActivity || listActivity.size() == 0) return;
        try {
            for (Activity activity:listActivity) {
                activity.finish();
            }
        } catch (Exception e) {
            Logger.e(e.getMessage());
        }
    }
}
