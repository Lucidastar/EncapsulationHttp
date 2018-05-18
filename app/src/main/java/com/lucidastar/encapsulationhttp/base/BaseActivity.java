package com.lucidastar.encapsulationhttp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by qiuyouzone on 2018/5/18.
 */

public class BaseActivity extends RxAppCompatActivity {

    protected Context mContext = null;
    protected BaseActivity mActivity = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mActivity = this;
    }
}
