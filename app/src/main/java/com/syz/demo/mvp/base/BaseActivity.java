package com.syz.demo.mvp.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by shiyuzhe on 2018/9/9.
 * WeChat:18091664559
 * Description:
 */
public abstract class BaseActivity extends AppCompatActivity implements IBaseView {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBinding(DataBindingUtil.setContentView(this,getLayoutId()));
        initView();
    }
    protected abstract  int getLayoutId();

    protected abstract void initBinding(ViewDataBinding binding);

    protected abstract void initView();

}
