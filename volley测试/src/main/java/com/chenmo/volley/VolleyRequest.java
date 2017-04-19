package com.chenmo.volley;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

/**
 * 作者：沉默
 * 日期：2017/3/27
 * QQ:823925783
 */

public class VolleyRequest {
    public static StringRequest stringRequest;
    public static Context context;

    public static void RequestGet(Context mContext, String url, String tag, VolleyInterface vif) {
        MyApplication.getHttpRequestQueue().cancelAll(tag);
        stringRequest = new StringRequest(Request.Method.GET, url, vif.myLoadListener(), vif.myErrorListener());
        stringRequest.setTag(tag);
        MyApplication.getHttpRequestQueue().add(stringRequest);
        MyApplication.getHttpRequestQueue().start();
    }

    public static void RequestPost(Context mContext, String url, String tag, final Map<String,String>params, VolleyInterface vif) {
    MyApplication.getHttpRequestQueue().cancelAll(tag);
        stringRequest=new StringRequest(url,vif.myLoadListener(),vif.myErrorListener()){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        stringRequest.setTag(tag);
        MyApplication.getHttpRequestQueue().add(stringRequest);
        MyApplication.getHttpRequestQueue().start();
    }
}
