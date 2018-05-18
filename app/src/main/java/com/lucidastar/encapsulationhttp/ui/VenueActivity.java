package com.lucidastar.encapsulationhttp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.lucidastar.encapsulationhttp.R;
import com.lucidastar.encapsulationhttp.api.VenuePostApi;
import com.lucidastar.encapsulationhttp.base.BaseActivity;
import com.lucidastar.encapsulationhttp.bean.VenueListBean;
import com.lucidastar.encapsulationhttp.nettools.api.BaseApi;
import com.lucidastar.encapsulationhttp.nettools.http.HttpManager;
import com.lucidastar.encapsulationhttp.nettools.listener.HttpOnNextListener;
import com.mine.lucidastarutils.log.KLog;

public class VenueActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue);
    }

    public void loadData(View view) {
        BaseApi<VenueListBean> baseApi = new VenuePostApi(new HttpOnNextListener<VenueListBean>() {
            @Override
            public void onNext(VenueListBean venueListBean) {
//                KLog.d(venueListBean.toString());
//                Toast.makeText(VenueActivity.this,venueListBean.toString()+"年后",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }
        }, this);

        baseApi.setShowProgress(true);
        String baseUrl = baseApi.getBaseUrl();
        String url = baseApi.getUrl();
        HttpManager.getInstance().doHttpDeal(baseApi);
    }
}
