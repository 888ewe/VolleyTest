package com.chenmo.volley;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * 作者：沉默
 * 日期：2017/3/27
 * QQ:823925783
 */

public class MyApplication extends Application {
    public  static RequestQueue requestQueue;
    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue= Volley.newRequestQueue(getApplicationContext());
    }

    public static RequestQueue getHttpRequestQueue(){
        return requestQueue;
    }
}
