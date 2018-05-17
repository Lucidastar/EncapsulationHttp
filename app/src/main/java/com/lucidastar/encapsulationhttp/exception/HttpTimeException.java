package com.lucidastar.encapsulationhttp.exception;

/**
 * Created by qiuyouzone on 2018/4/28.
 */

public class HttpTimeException extends RuntimeException {

    public static final int NO_DATA = 0x2;
    public static final int MSG_NO_NET = 0x3;

    public HttpTimeException(int resultCode) {
        this(getApiExceptionMessage(resultCode));
    }

    public HttpTimeException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * 转换错误数据
     *
     * @param code
     * @return
     */
    private static String getApiExceptionMessage(int code) {
        String message = "";
        switch (code) {
            case NO_DATA:
                message = "无数据";
                break;
            case MSG_NO_NET:
                message = "无网络";
                break;
            default:
                message = "error";
                break;

        }
        return message;
    }
}
