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
import com.lucidastar.encapsulationhttp.utils.MyConstant;
import com.mine.lucidastarutils.log.KLog;
import com.mine.lucidastarutils.utils.ToastUtils;

import java.util.HashMap;
import java.util.Map;

public class VenueActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue);
    }

    public void loadData(View view) {
        for (int i = 0; i < 200; i++) {
            Map<String,String> params = new HashMap<>();
            BaseApi<VenueListBean> baseApi = new VenuePostApi(new HttpOnNextListener<VenueListBean>() {
                @Override
                public void onNext(VenueListBean venueListBean) {
//                    ToastUtils.showShortToastSafe(venueListBean.getStatiumBean().getData().get(0).toString());
//                    KLog.i(venueListBean.getStatiumBean().getData().get(0).toString());
                }

                @Override
                public void onError(Throwable e) {
                    super.onError(e);
                }
            }, this,MyConstant.VENUE_SERVICE,MyConstant.VENUE_METHOD,params);
            if (i == 0){
                baseApi.setShowProgress(true);
            }else {
                baseApi.setShowProgress(false);
            }
            baseApi.setCancel(true);
            String baseUrl = baseApi.getBaseUrl();
            String url = baseApi.getUrl();
            KLog.d("baseUrl="+baseUrl+",url="+url);
            HttpManager.getInstance().doHttpDeal(baseApi);
        }

    }
}
