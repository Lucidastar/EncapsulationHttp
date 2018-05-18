package com.lucidastar.encapsulationhttp.utils;

import android.util.Log;

import com.google.gson.JsonObject;

import java.util.Iterator;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by qiuyouzone on 2018/5/18.
 */

public class ParamsUtils {
    public static String getJsonObjectParams(String service, String method, Map<String, String> parms, boolean isContainToken) {
//        if (parms == null) {
//            throw new ParameIsNullException();
//        }

        RequestParams params1 = new RequestParams(service, method);
        if (!isContainToken){
            params1.removeToken();
        }
        if (parms != null && !parms.isEmpty()) {
            Iterator iter = parms.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                params1.put((String) entry.getKey(),(String)entry.getValue());

            }
        }

        JsonObject jsonObject = params1.getJsonObject();

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
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),jsonObjectParams);
        return requestBody;
    }

}
