package com.lucidastar.encapsulationhttp.otherhttp.exception;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.HttpException;

/**
 * Created by qiuyouzone on 2019/5/10.
 */

public class ExceptionHandle extends Exception {
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;

    private final int code;
    private String message;

    public ExceptionHandle(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
        this.message = throwable.getMessage();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public static ResponeThrowable handleException(Throwable e) {
        ResponeThrowable ex;

        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            ex = new ResponeThrowable(e, ERROR.HTTP_ERROR);
            switch (httpException.code()) {
                case UNAUTHORIZED:
                case FORBIDDEN:
                case NOT_FOUND:
                case REQUEST_TIMEOUT:
                case GATEWAY_TIMEOUT:
                case INTERNAL_SERVER_ERROR:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                default:
                    ex.message = "网络错误";
                    break;
            }
            return ex;
        } else if (e instanceof ServerException) {
            ServerException resultException = (ServerException) e;
            ex = new ResponeThrowable(resultException, resultException.code);
            ex.message = resultException.message;
            return ex;
        } else if (e instanceof JsonParseException
                || e instanceof JSONException) {
            ex = new ResponeThrowable(e, ERROR.PARSE_ERROR);
            ex.message = "解析错误";
            return ex;
        } else if (e instanceof ConnectException) {
            ex = new ResponeThrowable(e, ERROR.NETWORD_ERROR);
            ex.message = "加载失败，请检查网络状态";
            return ex;
        } else if (e instanceof javax.net.ssl.SSLHandshakeException) {
            ex = new ResponeThrowable(e, ERROR.SSL_ERROR);
            ex.message = "证书验证失败";
            return ex;
        }else if (e instanceof SocketTimeoutException){
            ex = new ResponeThrowable(e, ERROR.TIME_OUT_ERROR);
            ex.message = "链接超时";
            return ex;
        }else {
            ex = new ResponeThrowable(e, ERROR.UNKNOWN);
//            ex.message = "未知错误";
            ex.message = "";
            return ex;
        }
    }


    /**
     * 约定异常
     */
    class ERROR {
        /**
         * 未知错误
         */
        public static final int UNKNOWN = 1000;
        /**
         * 解析错误
         */
        public static final int PARSE_ERROR = 1001;
        /**
         * 网络错误
         */
        public static final int NETWORD_ERROR = 1002;
        /**
         * 协议出错
         */
        public static final int HTTP_ERROR = 1003;

        /**
         * 证书出错
         */
        public static final int SSL_ERROR = 1005;
        /**
         * 超时
         */
        public static final int TIME_OUT_ERROR = 1006;
    }

    public static class ResponeThrowable extends Exception {
        public int code;
        public String message;

        public ResponeThrowable(Throwable throwable, int code) {
            super(throwable);
            this.code = code;
        }
        public ResponeThrowable(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }

    /**
     * ServerException发生后，将自动转换为ResponeThrowable返回
     */
    public static class ServerException extends RuntimeException {
        public int code;
        public String message;
        public Object mObject;
        public ServerException() {

        }

        public ServerException(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public ServerException(int code, String message, Object object) {
            this.code = code;
            this.message = message;
            mObject = object;
        }

        public ServerException(String message) {
            super(message);
            this.message = message;
        }

        public ServerException(int  code) {
            this.code = code;
        }
    }

}
