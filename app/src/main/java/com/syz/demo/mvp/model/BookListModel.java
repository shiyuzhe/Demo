package com.syz.demo.mvp.model;

import com.syz.demo.mvp.model.bean.BookListBean;
import com.syz.demo.net.RetrofitFactory;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by shiyuzhe on 2018/9/8.
 * WeChat:18091664559
 * Description:
 */
public class BookListModel {
    public Observable<ArrayList<BookListBean>> requestBookListData(String string) {
        return RetrofitFactory.getService().getBookList(string).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
