package com.example.administrator.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.FrameLayout;

public class EventTestActivity extends AppCompatActivity {

    public com.example.administrator.view.MidLayout midLayout;
    public Button btn;
    public String TAG = "Button";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_test);
        midLayout = (com.example.administrator.view.MidLayout)findViewById(R.id.mid_layout);
        btn = new Button(this)
        {
            @Override
            public boolean dispatchTouchEvent(MotionEvent ev) {

                switch (ev.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        Log.e(TAG, "dispatchTouchEvent ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.e(TAG, "dispatchTouchEvent ACTION_MOVE");
                        break;
                }

                boolean flag = super.dispatchTouchEvent(ev);

                switch (ev.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        Log.e(TAG, "dispatchTouchEvent ACTION_DOWN:" + flag);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.e(TAG, "dispatchTouchEvent ACTION_MOVE:" + flag);
                        break;
                }


                return flag;
            }


            @Override
            public boolean onTouchEvent(MotionEvent ev) {


                switch (ev.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        Log.e(TAG, "onTouchEvent ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.e(TAG, "onTouchEvent ACTION_MOVE");
                        break;
                }

                boolean flag = super.onTouchEvent(ev);

                switch (ev.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        Log.e(TAG, "onTouchEvent ACTION_DOWN:" + flag);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.e(TAG, "onTouchEvent ACTION_MOVE:" + flag);
                        break;
                }


                return flag;


            }
        };
        btn.setText(R.string.app_name);
        btn.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.WRAP_CONTENT));
        midLayout.addView(btn);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event_test, menu);
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
