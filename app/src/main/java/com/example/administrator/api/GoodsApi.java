package com.example.administrator.api;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.utils.CallBack;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by Administrator on 2015/7/23.
 */
public class GoodsApi {
    private RequestQueue mQueue;

    public GoodsApi(RequestQueue queue)
    {
        mQueue = queue;
    }
    public void GetGoodsPageList(Map<String, String> data, final CallBack<JSONObject> callBack)
    {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://192.168.1.85/test/json.php", null,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    callBack.onExecute(response);
                }
            },
            new Response.ErrorListener() {
                @Override
                 public void onErrorResponse(VolleyError error) {
                    Log.e("TAG", error.getMessage(), error);
                }
            }
        );
        mQueue.add(jsonObjectRequest);
    }
}
