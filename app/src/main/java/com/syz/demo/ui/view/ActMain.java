package com.syz.demo.ui.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.util.Log;
import android.view.View;

import com.syz.demo.R;
import com.syz.demo.databinding.ActMainBinding;
import com.syz.demo.mvp.base.BaseActivity;
import com.syz.demo.mvp.model.bean.User;
import com.syz.demo.net.ApiService;
import com.syz.demo.mvp.model.bean.BookListBean;
import com.syz.demo.net.RetrofitFactory;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class ActMain extends BaseActivity {
    ActMainBinding binding;

    @Override
    protected int getLayoutId() {
        return R.layout.act_main;
    }

    @Override
    protected void initBinding(ViewDataBinding binding) {
        this.binding = (ActMainBinding) binding;
    }

    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.act_main);
        User user = new User("12", "dashan", "16");
        binding.setUser(user);
        binding.setHandler(new EventHandler());
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dimissLoading() {

    }


    public class EventHandler {
        public void getBookList(View view) {
            Log.e("syz", "click");
            RetrofitFactory.getRetrofit().create(ApiService.class).getBookList("1").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ArrayList<BookListBean>>() {
                @Override
                public void accept(ArrayList<BookListBean> bookListBeans) throws Exception {
                    Log.e("syz", "size:" + bookListBeans.size());
                    binding.setBook(bookListBeans.get(0));
                }
            });
        }

        public void intentToBookList(View view) {
            startActivity(new Intent(ActMain.this, ActBookList.class));
        }
    }


}
