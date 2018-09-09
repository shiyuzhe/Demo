package com.syz.demo.ui.view;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.syz.demo.R;
import com.syz.demo.databinding.ActBookListBinding;
import com.syz.demo.mvp.base.BaseActivity;
import com.syz.demo.mvp.contract.BookListContract;
import com.syz.demo.mvp.model.bean.BookListBean;
import com.syz.demo.mvp.presenter.BookListPresenter;
import com.syz.demo.ui.adapter.BookListAdapter;
import com.syz.demo.ui.adapter.BookListAdapter2;

import java.util.ArrayList;

public class ActBookList extends BaseActivity implements BookListContract.View {
    private BookListPresenter mPresenter;
    private ActBookListBinding binding;
    private BookListAdapter2 adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.act_book_list;
    }

    @Override
    protected void initBinding(ViewDataBinding binding) {
        this.binding = (ActBookListBinding) binding;
    }

    @Override
    protected void initView() {
        mPresenter = new BookListPresenter();
        mPresenter.attachView(this);
        mPresenter.requestBookListData("1");
        adapter = new BookListAdapter2(this);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
    }


    @Override
    public void setBookLisMore(ArrayList<BookListBean> bookListBeans) {

    }

    @Override
    public void setBookListData(ArrayList<BookListBean> bookListBeans) {
        Log.e("syz", bookListBeans.get(0).toString());
        adapter.setItems(bookListBeans);
    }

    @Override
    public void showError(String msg, int errorCode) {
        Log.e("syz", msg);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dimissLoading() {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

}
