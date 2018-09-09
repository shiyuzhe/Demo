package com.syz.demo.net;

/**
 * Created by shiyuzhe on 2018/9/8.
 * WeChat:18091664559
 * Description:
 */
public class ApiException extends RuntimeException {
    private int code;

    public ApiException(Throwable throwable, int code) {
        super(throwable);
        this.code = code;

    }

    public ApiException(String string) {
        super(new Throwable(string));
    }
}
