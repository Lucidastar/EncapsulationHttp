package com.lucidastar.encapsulationhttp.otherhttp.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.lucidastar.encapsulationhttp.otherhttp.integration.lifecycle.ActivityLifecycleable;
import com.trello.rxlifecycle2.android.ActivityEvent;

import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by qiuyouzone on 2019/5/10.
 */

public abstract class BaseActivity extends AppCompatActivity implements ActivityLifecycleable {
    private final BehaviorSubject<ActivityEvent> mLifecycleSubject = BehaviorSubject.create();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        init(savedInstanceState);
    }

    @NonNull
    @Override
    public final Subject<ActivityEvent> provideLifecycleSubject() {
        return mLifecycleSubject;
    }
    protected void showToast(String msg) {
    }

    protected abstract @LayoutRes int getLayoutId();

    protected abstract void init(Bundle savedInstanceState);

}
