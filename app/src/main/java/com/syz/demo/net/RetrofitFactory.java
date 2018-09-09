package com.syz.demo.net;

import com.syz.demo.MyApplication;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shiyuzhe on 2018/9/8.
 * WeChat:18091664559
 * Description:
 */
public class RetrofitFactory {
    private static String BASE_URL = "https://api.zmbai.com/v1/";
    private static final long DEFAULT_TIMEOUT = 60L;
    private static final String HEADER_CONNECTION = "keep-alive";
    private static Retrofit retrofit;

    public static ApiService getService() {
        return getRetrofit().create(ApiService.class);
    }

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            synchronized (RetrofitFactory.class) {
                if (retrofit == null) {
                    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    File file = new File(MyApplication.getContext().getCacheDir(), "cache");
                    Cache cache = new Cache(file, 1024 * 1024 * 50);
                    OkHttpClient mClient = new OkHttpClient.Builder()
                            .addInterceptor(new HeaderInterceptor()) // token过滤
                            .addInterceptor(new CacheInterceptor())
                            .addInterceptor(httpLoggingInterceptor) //日志,所有的请求响应度看到
                            .addNetworkInterceptor(new CacheInterceptor())
                            .cache(cache)
                            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            .build();
                    retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)//基础URL 建议以 / 结尾
                            .addConverterFactory(GsonConverterFactory.create())//设置 Json 转换器
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//RxJava 适配器
                            .client(mClient)
                            .build();
                }
            }
        }
        return retrofit;
    }

    /**
     * header
     */
    public static class HeaderInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request requestBuilder = request.newBuilder()
                    .addHeader("Connection", HEADER_CONNECTION)
                    .addHeader("api_key", "mingjiazongxueguan")
                    .addHeader("authorization", "")// TOKEN
                    .method(request.method(), request.body())
                    .build();
            return chain.proceed(requestBuilder);
        }
    }

    /**
     * 设置缓存
     */
    public static class CacheInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            boolean isConnected = false;
            if (!isConnected) {
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response response = chain.proceed(request);
            // 有网络时 设置缓存超时时间0个小时 ,意思就是不读取缓存数据,只对get有用,post没有缓冲
            if (isConnected) {
                return response.newBuilder()
                        .header("Cache-Control", "public, max-age=" + 30)
                        .removeHeader("Pragma")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                        .build();
            } else {
                // 无网络时，设置超时为4周  只对get有用,post没有缓冲
                return response.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 28)
                        .removeHeader("Pragma")
                        .build();
            }
        }
    }
}
