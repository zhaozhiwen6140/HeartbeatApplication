package com.example.zhaozhiwen.heartbeatapplication.ToolUtil;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by zhaozhiwen on 2016/4/28.
 */
public class SystemUtil {

    private static float density = 0;
    private static int width;
    private static int height;


    /**
     * 根据手机和分辨率，将单位从dp转换成px(像素)
     * @param context
     * @param dipValue
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        if (density == 0)
            density = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * density + 0.5f);
    }

    /**
     * 根据手机和分辨率，将单位从px(像素)转换成dp
     */
    public static int px2dip(Context context, float pxValue) {
        density = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / density + 0.5f);
    }
    /**
     * 获得屏幕的宽度跟高度
     */
    public static int getWidth(Context context){
        DisplayMetrics dm =context.getResources().getDisplayMetrics();
        width = dm.widthPixels;
        height = dm.heightPixels;
        return width;
    }

    public static int getHeight(Context context){
        DisplayMetrics dm =context.getResources().getDisplayMetrics();
        height = dm.heightPixels;
        return height;
    }
}
