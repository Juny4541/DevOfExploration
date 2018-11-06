package com.example.juny.devofexploration;

import android.content.Context;
import android.content.Intent;

import com.example.juny.devofexploration.activity.AIDLActivity;

public class IntentManager {

    /**
     * 跳转到AIDL示例页面
     */
    public static void intentToAIDLActivity(Context context) {
        Intent intent = new Intent(context, AIDLActivity.class);
        context.startActivity(intent);
    }

}
