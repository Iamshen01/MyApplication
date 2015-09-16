package com.example.administrator.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by Administrator on 2015/8/11.
 */
public class OutLayout extends FrameLayout {

    public static final String TAG = "OutLayout";

    public OutLayout(Context context) {
        super(context);
    }
    public OutLayout(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

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

    public boolean onInterceptTouchEvent(MotionEvent ev) {



        switch (ev.getAction()) {

            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onInterceptTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "onInterceptTouchEvent ACTION_MOVE");
                break;
        }

        boolean flag = super.onInterceptTouchEvent(ev);


        switch (ev.getAction()) {

            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onInterceptTouchEvent ACTION_DOWN:" + flag);
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "onInterceptTouchEvent ACTION_MOVE:" + flag);
                break;
        }


        return flag;
    }
}
