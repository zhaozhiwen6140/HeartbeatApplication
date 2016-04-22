package com.example.zhaozhiwen.heartbeatapplication;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by zhaozhiwen on 2016/4/14.
 */
public class ApplicationContext extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
        Fresco.initialize(this);
    }

    public static Context getContext(){
        return mContext;
    }

}
