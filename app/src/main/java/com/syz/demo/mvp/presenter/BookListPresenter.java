package com.syz.demo.mvp.presenter;

import com.syz.demo.mvp.base.BasePresenter;
import com.syz.demo.mvp.contract.BookListContract;
import com.syz.demo.mvp.model.BookListModel;
import com.syz.demo.mvp.model.bean.BookListBean;
import com.syz.demo.net.ExceptionHandle;

import java.util.ArrayList;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by shiyuzhe on 2018/9/8.
 * WeChat:18091664559
 * Description:
 */
public class BookListPresenter extends BasePresenter<BookListContract.View> implements BookListContract.Presenter {
    private BookListModel bookListModel;

    private BookListModel getModel() {
        if (bookListModel == null)
            bookListModel = new BookListModel();
        return bookListModel;
    }

    @Override
    public void requestBookListData(String string) {
        checkViewAttached();
        mDocerView.showLoading();
        Disposable disposable = getModel().requestBookListData(string).subscribe(new Consumer<ArrayList<BookListBean>>() {
            @Override
            public void accept(ArrayList<BookListBean> bookListBeans) throws Exception {
                mDocerView.dimissLoading();
                mDocerView.setBookListData(bookListBeans);

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mDocerView.showError(ExceptionHandle.handleException(throwable), ExceptionHandle.errorCode);
            }
        });
        addSubscription(disposable);

    }

    @Override
    public void loadMoreBookListData(String string) {

    }

}
