package com.syz.demo.mvp.contract;

import com.syz.demo.mvp.base.IBaseView;
import com.syz.demo.mvp.base.IPresenter;
import com.syz.demo.mvp.model.bean.BookListBean;

import java.util.ArrayList;

/**
 * Created by shiyuzhe on 2018/9/8.
 * WeChat:18091664559
 * Description:
 */
public class BookListContract {

    public interface View extends IBaseView {
        void setBookLisMore(ArrayList<BookListBean> bookListBeans);

        void setBookListData(ArrayList<BookListBean> bookListBeans);

        /**
         * 显示错误信息
         */
        void showError(String msg, int errorCode);
    }

    public interface Presenter extends IPresenter<View> {
        /**
         * 获取书单信息
         */
        void requestBookListData(String string);

        /**
         * 加载更多书单信息
         */
        void loadMoreBookListData(String string);
    }
}
