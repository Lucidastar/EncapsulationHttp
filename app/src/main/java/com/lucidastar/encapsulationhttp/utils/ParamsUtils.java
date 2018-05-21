package com.lucidastar.encapsulationhttp.utils;

import com.google.gson.JsonObject;

import java.util.Iterator;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * Created by qiuyouzone on 2018/5/18.
 */

public class ParamsUtils {
    public static String getJsonObjectParams(String service, String method, Map<String, String> params, boolean isContainToken) {
//        if (parms == null) {
//            throw new ParameIsNullException();
//        }

        RequestParams param = new RequestParams(service, method);
        if (!isContainToken){
            param.removeToken();
        }
        if (params != null && !params.isEmpty()) {
            Iterator iter = params.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                param.put((String) entry.getKey(),(String)entry.getValue());

            }
        }

        JsonObject jsonObject = param.getJsonObject();

        //打印日志
        /*if (BuildConfig.LOG_DEBUG) {
            String str = "";
            try {
                str = jsonObject.toString();
            } catch (Exception e) {
                e.printStackTrace();
                str = e.getMessage();
            }
            Log.i("params:", str);
        }*/

        return jsonObject.toString();
    }

    public static RequestBody getRequestBody(String service, String method, Map<String, String> parms, boolean isContainToken){
        String jsonObjectParams = getJsonObjectParams(service, method, parms, isContainToken);
        RequestBody requestBody = new FormBody.Builder().add("body",jsonObjectParams).build();
        return requestBody;
    }

}
