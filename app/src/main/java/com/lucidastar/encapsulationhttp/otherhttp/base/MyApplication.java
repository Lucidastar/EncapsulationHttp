package com.lucidastar.encapsulationhttp.otherhttp.base;

import android.app.Application;

import com.mine.lucidastarutils.utils.Utils;

/**
 * Created by qiuyouzone on 2019/5/10.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this,true,"lucidastar");
    }
}
