package com.example.administrator.myapplication;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.administrator.adapter.GoodsListAdapter;
import com.example.administrator.utils.CallBack;
import com.example.administrator.api.GoodsApi;
import com.example.administrator.utils.BitmapCache;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class ListViewTestActivity extends ActionBarActivity {

    protected ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);
        listView = (ListView)findViewById(R.id.listView);

        RequestQueue mQueue = Volley.newRequestQueue(this);
        final ImageLoader imageLoader = new ImageLoader(mQueue, new BitmapCache());
        GoodsApi goods = new GoodsApi(mQueue);
        goods.GetGoodsPageList(null, new CallBack<JSONObject>() {
            @Override
            public void onExecute(JSONObject response) {
                Log.d("TAG", response.toString());
                try {
                    JSONArray array = response.getJSONObject("result").getJSONArray("goods");
                    Log.d("TAG", array.toString());
                    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                    int len = array.length();
                    for (int i = 0; i < len; i++) {
                        JSONObject item = array.getJSONObject(i);
                        Map<String, Object> map = new HashMap<String, Object>();
                        Iterator<String> keys = item.keys();
                        while (keys.hasNext()) {
                            String key = keys.next();
                            map.put(key, item.get(key));
                        }
                        list.add(map);
                    }
                    GoodsListAdapter adapter = new GoodsListAdapter(ListViewTestActivity.this, list, imageLoader);
                    listView.setAdapter(adapter);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_view_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
