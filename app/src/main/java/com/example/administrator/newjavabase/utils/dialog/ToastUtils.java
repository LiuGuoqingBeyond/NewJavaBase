package com.example.administrator.newjavabase.utils.dialog;

import android.widget.Toast;

import com.example.administrator.newjavabase.base.app.GlobalApp;


/**
 * User: Axl_Jacobs(Axl.Jacobs@gmail.com)
 * Date: 2017/5/27
 * Time: 下午5:02
 */

public class ToastUtils {
    public static void showShort(String msg) {
        Toast.makeText(GlobalApp.getAppContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(String msg) {
        Toast.makeText(GlobalApp.getAppContext(), msg, Toast.LENGTH_LONG).show();
    }
}
