package com.syz.demo.mvp.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by shiyuzhe on 2018/9/8.
 * WeChat:18091664559
 * Description:
 */
public class BasePresenter<V extends IBaseView> implements IPresenter<V> {

    protected V mDocerView;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void attachView(V mDocerView) {
        this.mDocerView = mDocerView;
    }

    @Override
    public void detachView() {
        //保证activity结束时取消所有正在执行的订阅
        mDocerView = null;
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.clear();
        }
    }

    public void checkViewAttached() {
        if (mDocerView == null) throw new MvpViewNotAttachedException();
    }

    public void addSubscription(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    private static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call IPresenter.attachView(IBaseView) before" + " requesting data to the IPresenter");
        }
    }

}
