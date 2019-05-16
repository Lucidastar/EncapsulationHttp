package com.lucidastar.encapsulationhttp.otherhttp.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by qiuyouzone on 2019/5/10.
 */

public abstract class BaseActivity extends RxAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        init(savedInstanceState);


    }
    protected void showToast(String msg) {
    }

    protected abstract @LayoutRes int getLayoutId();

    protected abstract void init(Bundle savedInstanceState);

}
