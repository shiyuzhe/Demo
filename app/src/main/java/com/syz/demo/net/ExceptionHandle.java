package com.syz.demo.net;

import android.util.Log;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.logging.Logger;

/**
 * Created by shiyuzhe on 2018/9/8.
 * WeChat:18091664559
 * Description:
 */
public abstract class ExceptionHandle {
    private static final int SUCCESS = 0;//响应成功
    private static final int UNKNOWN_ERROR = 1002;//未知错误
    private static final int SERVER_ERROR = 1003;//服务器内部错误
    private static final int NETWORK_ERROR = 1004;//网络连接超时
    private static final int API_ERROR = 1005;//API解析异常（或者第三方数据结构更改）等其他异常

    public static int errorCode = UNKNOWN_ERROR;
    public static String errorMsg = "请求失败，请稍后重试";

    public static String handleException(Throwable e) {
        e.printStackTrace();
        if (e instanceof SocketTimeoutException) {//网络超时
            Log.e("TAG", "网络连接异常: " + e.getMessage());
            errorMsg = "网络连接异常";
            errorCode = NETWORK_ERROR;
        } else if (e instanceof ConnectException) { //均视为网络错误
            Log.e("TAG", "网络连接异常: " + e.getMessage());
            errorMsg = "网络连接异常";
            errorCode = NETWORK_ERROR;
        } else if (e instanceof JsonParseException
                    || e instanceof JSONException
                || e instanceof ParseException) {   //均视为解析错误
            Log.e("TAG", "数据解析异常: " + e.getMessage());
            errorMsg = "数据解析异常";
            errorCode = SERVER_ERROR;
        } else if (e instanceof ApiException) {//服务器返回的错误信息
            errorMsg = e.getMessage().toString();
            errorCode = SERVER_ERROR;
        } else if (e instanceof UnknownHostException) {
            Log.e("TAG", "网络连接异常: " + e.getMessage());
            errorMsg = "网络连接异常";
            errorCode = NETWORK_ERROR;
        } else if (e instanceof IllegalArgumentException) {
            errorMsg = "参数错误";
            errorCode = SERVER_ERROR;
        } else {//未知错误
            try {
                Log.e("TAG", "错误: " + e.getMessage());
            } catch (Exception e1) {
                Log.e("TAG", "未知错误Debug调试 ");
            }

            errorMsg = "未知错误，可能抛锚了吧~";
            errorCode = UNKNOWN_ERROR;
        }
        return errorMsg;
    }
}
