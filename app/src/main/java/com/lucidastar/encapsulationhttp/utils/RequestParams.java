package com.lucidastar.encapsulationhttp.utils;

import android.text.TextUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lucidastar.encapsulationhttp.MyApplication;

import java.util.UUID;

/**
 * Created by qiuyouzone on 2018/5/18.
 */

public class RequestParams {
    //! 请求的JSON对象
    private JsonObject requestJsonExpression;
    //! 请求的具体参数对象
    private JsonObject paramsJsonExpression;


    public JsonObject getJsonObject(){
        return requestJsonExpression;
    }


    public RequestParams(String service,String method,JsonObject paramsJson){
        //新建一个请求参数的JSON字符串
        if (TextUtils.isEmpty(service)) {
//            throw new ParameIsNullException();
        }
        if (TextUtils.isEmpty(method)) {
//            throw new ParameIsNullException();
        }

        requestJsonExpression = new JsonObject();
        addDefaultParams(requestJsonExpression);
        requestJsonExpression.addProperty("service", service);
        requestJsonExpression.addProperty("method", method);
        requestJsonExpression.add("params", paramsJson);
    }

    public RequestParams(String service,String method) {
        //新建一个请求参数的JSON字符串
        if (TextUtils.isEmpty(service)) {
//            throw new ParameIsNullException();
        }
        if (TextUtils.isEmpty(method)) {
//            throw new ParameIsNullException();
        }

        requestJsonExpression = new JsonObject();
        paramsJsonExpression = new JsonObject();
        addDefaultParams(requestJsonExpression);
        requestJsonExpression.addProperty("service", service);
        requestJsonExpression.addProperty("method", method);
        requestJsonExpression.add("params", paramsJsonExpression);
        //  super.put(HttpFactory.PARAMS_NAME, requestJsonExpression.toString());
    }

    /**
     * @param requestJsonExpression
     * @brief 增加默认的参数
     */
    private void addDefaultParams(JsonObject requestJsonExpression) {

        //默认添加TOKEN
//        if (!TextUtils.isEmpty(MyApplication.getInstance().getToken()))
//            addTopLevelParams("token", MyApplication.getInstance().getToken());

        //默认添加渠道号
//        if (!TextUtils.isEmpty(MyApplication.getInstance().getChannel()))
//            addTopLevelParams("channel", MyApplication.getInstance().getChannel());

//        //默认添加APP版本号
//        if (!TextUtils.isEmpty(MyApplication.getInstance().getVersionCode()))
//            addTopLevelParams("version", MyApplication.getInstance().getVersionCode());
//
//        //默认添加APP版本号
//        if (!TextUtils.isEmpty(MyApplication.getInstance().getIMEI()))
//            addTopLevelParams("imei", MyApplication.getInstance().getIMEI());

        //默认添加UUID
        addTopLevelParams("sn", UUID.randomUUID().toString());
    }


    /**
     * @param key
     * @param value
     * @brief 增加与service 和Method 同等级参数
     */
    public void addTopLevelParams(String key, String value) {
        if (requestJsonExpression != null) {
            //默认添加TOKEN
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                requestJsonExpression.addProperty(key, value);
                //    super.put(HttpManager.PARAMS_NAME, requestJsonExpression.toString());
            }
        }
    }


    /**
     * @brief 删除请求中token
     */
    public void removeToken() {
        try {
            if (requestJsonExpression != null) {
                //默认添加TOKEN
                Object token = requestJsonExpression.remove("token");
                //super.put(HttpManager.PARAMS_NAME, requestJsonExpression.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void put(String key, String value) {
        if (value != null)
            paramsJsonExpression.addProperty(key, value);

    }


    public void put(String key, Object value) {
        if (value != null) {
            String s = GsonUtil.bean2json(value);
            //  JsonObject jsonObject = JsonObject;
            paramsJsonExpression.add(key, new JsonParser().parse(s).getAsJsonObject());
        }
        //提交 post／get 请求，参数名都为 body
        //   super.put(HttpManager.PARAMS_NAME, requestJsonExpression.toString());
    }

    public void put(String key, JsonObject value) {
        if (value != null) {
            paramsJsonExpression.add(key, value);
            //     super.put(HttpManager.PARAMS_NAME, requestJsonExpression.toString());
        }
    }

    public void put(String key, int value) {
        if (value != -1)
            paramsJsonExpression.addProperty(key, value);
        //提交 post／get 请求，参数名都为 body
        //  super.put(HttpManager.PARAMS_NAME, requestJsonExpression.toString());
    }

    public void setParamsJsonExpression(JsonObject paramsJson){
        paramsJsonExpression=paramsJson;
    }

    /**
     * @return
     * @brief 获得请求的JSON串
     */
    public String getRequestJsonExpression() {
        return requestJsonExpression.toString();
    }

}
