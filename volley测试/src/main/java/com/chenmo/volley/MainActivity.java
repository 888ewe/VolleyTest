package com.chenmo.volley;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        volleyGet();
//        volleyPost();
    }

    private void volleyPost() {
        String url = "http://v.juhe.cn/xiangji_weather/real_time_weather.php?";

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Toast.makeText(MainActivity.this, s.toString(), Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(MainActivity.this, volleyError.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("areaid", "101010100");
                map.put("key", "a0ceb976fe01a8b53e87b581a9c10a99");
                return map;
            }
        };

        request.setTag("appPost");
        MyApplication.getHttpRequestQueue().add(request);
    }


    private void volleyGet() {
        String url = "http://v.juhe.cn/xiangji_weather/real_time_weather.php?areaid=101010100&key=a0ceb976fe01a8b53e87b581a9c10a99";
        VolleyRequest.RequestGet(this, url, "appGet", new VolleyInterface(this, VolleyInterface.mListener, VolleyInterface.mErrorListener) {
            @Override
            public void onMySuccess(String result) {
                Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMyError(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        MyApplication.getHttpRequestQueue().cancelAll("abcGet");
    }
}
