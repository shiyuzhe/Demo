package com.syz.demo.net;

import com.syz.demo.mvp.model.bean.BookListBean;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by shiyuzhe on 2018/9/8.
 * WeChat:18091664559
 * Description:
 */
public interface ApiService {
    @GET("booklists")
    Observable<ArrayList<BookListBean>> getBookList(@Query("id") String id);
}
