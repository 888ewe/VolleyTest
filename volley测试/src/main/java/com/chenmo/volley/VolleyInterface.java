package com.chenmo.volley;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * 作者：沉默
 * 日期：2017/3/27
 * QQ:823925783
 */

public abstract class VolleyInterface {
    public Context mContext;
    public static Response.Listener<String> mListener;
    public static Response.ErrorListener mErrorListener;


    public VolleyInterface(Context context, Response.Listener<String> listener, Response.ErrorListener errorListener){
        this.mContext=context;
        this.mListener=listener;
        this.mErrorListener=errorListener;
    }
    public Response.Listener<String> myLoadListener(){
        mListener=new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                onMySuccess(s);
            }
        };
        return mListener;

    }
    public Response.ErrorListener myErrorListener(){
        mErrorListener=new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                onMyError(volleyError);
            }
        };
        return mErrorListener;

    }
    public abstract void onMySuccess(String result);
    public abstract void onMyError(VolleyError error);

}

