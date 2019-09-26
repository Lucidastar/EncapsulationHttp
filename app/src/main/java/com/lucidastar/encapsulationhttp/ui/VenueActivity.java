package com.lucidastar.encapsulationhttp.ui;

import android.os.Bundle;
import android.view.View;

import com.lucidastar.encapsulationhttp.R;
import com.lucidastar.encapsulationhttp.otherhttp.HttpManager1;
import com.lucidastar.encapsulationhttp.otherhttp.api.user.UserService;
import com.lucidastar.encapsulationhttp.otherhttp.base.BaseActivity;
import com.lucidastar.encapsulationhttp.otherhttp.listener.HttpOnNextListener;
import com.lucidastar.encapsulationhttp.otherhttp.mode.UserModel;
import com.lucidastar.encapsulationhttp.otherhttp.subscribers.ProgressSubscriber;
import com.lucidastar.encapsulationhttp.otherhttp.utils.RxLifecycleUtils;
import com.lucidastar.encapsulationhttp.otherhttp.utils.RxUtils;
import com.mine.lucidastarutils.log.KLog;
import com.mine.lucidastarutils.utils.ToastUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VenueActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_venue;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    public void loadData(View view) {
        studyOkHttp();
//        testLife();

    }

    private void testLife() {
       /* for (int i = 0; i < 1; i++) {
            Map<String, String> params = new HashMap<>();
            BaseApi<VenueListBean> baseApi = new VenuePostApi(new HttpOnNextListener<VenueListBean>() {
                @Override
                public void onNext(VenueListBean venueListBean) {
                    ToastUtils.showShortToastSafe(venueListBean.getStatiumBean().getData().get(0).toString());
//                    KLog.i(venueListBean.getStatiumBean().getData().get(0).toString());
                }

                @Override
                public void onError(Throwable e) {
                    super.onError(e);
                }
            }, this, MyConstant.VENUE_SERVICE, MyConstant.VENUE_METHOD, params);
            if (i == 0) {
                baseApi.setShowProgress(true);
            } else {
                baseApi.setShowProgress(false);
            }
            baseApi.setCancel(true);
            String baseUrl = baseApi.getBaseUrl();
            String url = baseApi.getUrl();
            KLog.d("baseUrl=" + baseUrl + ",url=" + url);
            HttpManager.getInstance().doHttpDeal(baseApi);
        }*/
    }


    private void studyOkHttp() {

        HttpManager1.getInstance().createService(UserService.class)
        .getUsers(1,20)
        .delay(8, TimeUnit.SECONDS)
        .compose(RxUtils.<List<UserModel>>switchSchedulers())
        .compose(RxLifecycleUtils.<List<UserModel>>bindToLifecycle(this))
         .subscribe(new ProgressSubscriber<>(new HttpOnNextListener<List<UserModel>>() {
            @Override
            public void onNext(List<UserModel> userModels) {
                KLog.i(userModels.size()+"");
                ToastUtils.showShortToast("数据的大小:"+userModels.size());
            }
        }));
//        Lifecycle
    }


    private void studyHttpUrlConnection() {
        try {
            URL url = new URL("https://www.baidu.com");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //设置连接超时,2000ms
            urlConnection.setConnectTimeout(2000);
            //设置指定时间内服务器没有返回数据的超时，5000ms
            urlConnection.setReadTimeout(5000);
            //设置参数
            urlConnection.setDoOutput(true);   //需要输出
            urlConnection.setDoInput(true);   //需要输入
            urlConnection.setUseCaches(false);  //不允许缓存
            urlConnection.setRequestMethod("POST");
            //设置请求属性,给请求头添加东西
            urlConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            urlConnection.setRequestProperty("accept", "application/json");
            urlConnection.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
            urlConnection.setRequestProperty("Charset", "UTF-8");
            int resultCode = urlConnection.getResponseCode();//获取响应码
            if (HttpURLConnection.HTTP_OK == resultCode) {//表示请求成功
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
