package com.syz.demo.mvp.base;

/**
 * Created by shiyuzhe on 2018/9/8.
 * WeChat:18091664559
 * Description:
 */
public interface IPresenter<V extends IBaseView> {

    void attachView(V mDocerView);

    void detachView();
}
