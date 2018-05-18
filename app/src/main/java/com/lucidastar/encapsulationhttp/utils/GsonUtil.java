package com.lucidastar.encapsulationhttp.utils;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author 蒋洪波
 * @file GsonUtil.java
 * @brief Gson工具类
 * @date 2015-6-10
 * Copyright (c) 2015, 北京球友圈网络科技有限责任公司
 * All rights reserved.
 */
public class GsonUtil {
    /**
     * @param json
     * @param clazz
     * @param <T>
     * @return
     * @brief 将JSON转为实体
     */
    public static <T> T json2Bean(String json, Class<T> clazz) {

        Gson gson = new Gson();
        try {
            T t = gson.fromJson(json, clazz);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("GSON EX ++++++++++++" + e.toString());
            return null;
        }
    }

    /**
     * @param obj
     * @return
     * @brief 将一个对象装为Json格式的字符串
     */
    public static String bean2json(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    /**
     * 把json字符串解析成集合
     * params: new TypeToken<List<AppInfo>>(){}.getType(),
     *
     * @param json
     * @param type  new TypeToken<List<yourbean>>(){}.getType()
     * @return
     */
    public static List<?> parseJsonToList(String json, Type type) {
        Gson gson = new Gson();
        List<?> list = gson.fromJson(json, type);
        return list;
    }
}
