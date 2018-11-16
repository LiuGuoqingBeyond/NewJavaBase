package com.example.administrator.newjavabase.utils.app;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.text.TextUtils;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Map;

/**
 * User: Axl_Jacobs(Axl.Jacobs@gmail.com)
 * Date: 2017/11/17
 * Time: 14:50
 */

public class AppUtils {
    public static int getMetaDataInt(Context context, String name) {
        try {
            ApplicationInfo appInfo = context.getApplicationContext().getPackageManager()
                    .getApplicationInfo(context.getApplicationContext().getPackageName(),
                            PackageManager.GET_META_DATA);
            int logo = appInfo.metaData.getInt(name);
            return logo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    /*public static String getSignature(Map<String, String> params) {
        StringBuilder buffer = new StringBuilder();
        for (String value : params.values()) {
            buffer.append(value);
        }
        buffer.append(AppConstants.AUTHENTICATION_REQUEST_KEY);
        return Encrypt(buffer.toString());
    }*/


    public static String getMd5String(Map<String, String> params, String signature) {
        StringBuilder buffer = new StringBuilder();
        for (String value : params.values()) {
            buffer.append(value);
        }
        buffer.append(signature);
        return getMD5(buffer.toString()).toUpperCase(Locale.getDefault());
    }

    public static String getAppMd5String(Map<String, String> params, String signature) {
        StringBuilder buffer = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (!first) {
                buffer.append("&");
            }
            first = false;
            buffer.append(entry.getKey());
            buffer.append('=');
            if (entry.getValue() != null) {
                buffer.append(trimToEmpty(entry.getValue()));
            }
        }
        buffer.append("&" + signature);
        return getMD5(buffer.toString()).toUpperCase(Locale.getDefault());
    }

    public static String trimToEmpty(String s) {
        return s == null ? "" : s.trim();
    }

    public static String getSignature(Map<String, String> params, String signature) {
        return getSignature(params, signature, false);
    }

    public static String getSignature(Map<String, String> params, String signature, boolean toUpperCase) {
        StringBuilder buffer = new StringBuilder();
        for (String value : params.values()) {
            buffer.append(value);
        }
        buffer.append(signature);
        return toUpperCase ? Encrypt(buffer.toString()).toUpperCase() : Encrypt(buffer.toString());
    }

    public static String getMD5(String content) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(content.getBytes());
            return getHashString(digest);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getHashString(MessageDigest digest) {
        StringBuilder builder = new StringBuilder();
        for (byte b : digest.digest()) {
            builder.append(Integer.toHexString((b >> 4) & 0xf));
            builder.append(Integer.toHexString(b & 0xf));
        }
        return builder.toString();
    }

    public static String Encrypt(String strSrc) {
        MessageDigest md = null;
        StringBuilder sb = new StringBuilder();

        byte[] bt = strSrc.getBytes();
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] result = md.digest(bt);
            for (byte b : result) {
                sb.append(String.format("%02x", b));
            }
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return sb.toString();
    }

    public static String getCompressPath() {
        String path = Environment.getExternalStorageDirectory() + "/Luban/image/";
        File file = new File(path);
        if (file.mkdirs()) {
            if (!new File(path + ".nomedia").exists()) {
                new File(path + ".nomedia").mkdirs();
            }
            return path;
        }
        return path;
    }

    /*public static String saveBitmap2File(Bitmap bitmap, String fileName) {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bao);
        byte[] srcBytes = bao.toByteArray();
        File file = FileUtils.byte2File(srcBytes, AppUtils.getCompressPath(), fileName);
        return file.getPath();
    }

    public static List<Integer> getNavigationList(NewLoginInfo.FunctionsBean bean) {
        List<Integer> integers = new ArrayList<>();
        if (bean.payment == null || TextUtils.equals(bean.payment.isShow, "0")) {
            integers.add(R.id.navigation_home);
        }
        if (bean.xinyongka == null || TextUtils.equals(bean.xinyongka.isShow, "0")) {
            integers.add(R.id.navigation_credit);
        }
        if (bean.tuiguangyoujiang == null || TextUtils.equals(bean.tuiguangyoujiang.isShow, "0")) {
            integers.add(R.id.navigation_generalize);
        }
        if (bean.wode == null || TextUtils.equals(bean.wode.isShow, "0")) {
            integers.add(R.id.navigation_me);
        }

        return integers;
    }*/

    public static String setUrlParams(String url, Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        builder.append(url).append("?");
        if (params != null && params.size() > 0) {
            for (String key : params.keySet()) {
                String value = params.get(key);
                if (!TextUtils.isEmpty(value)) {
                    builder.append(key).append("=").append(value).append("&");
                }
            }
        }
        return builder.toString().endsWith("&") ? builder.substring(0, builder.length() - 1) : builder.toString();
    }
}
