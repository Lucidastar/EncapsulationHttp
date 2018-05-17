package com.lucidastar.encapsulationhttp;

import android.app.Application;

import com.mine.lucidastarutils.utils.Utils;

/**
 * Created by qiuyouzone on 2018/5/17.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this,true,"lucidastar");
    }
}
