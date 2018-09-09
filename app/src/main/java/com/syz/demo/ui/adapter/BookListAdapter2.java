package com.syz.demo.ui.adapter;

import android.content.Context;

import com.syz.demo.R;
import com.syz.demo.mvp.model.bean.BookListBean;
import com.syz.demo.databinding.ItemBookBinding;

/**
 * Created by shiyuzhe on 2018/9/9.
 * WeChat:18091664559
 * Description:
 */
public class BookListAdapter2 extends SimpleAdapter<BookListBean, ItemBookBinding> {

    public BookListAdapter2(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.item_book;
    }

    @Override
    protected void onBindItem(ItemBookBinding binding, BookListBean item) {
        binding.setItem(item);
        binding.executePendingBindings();
    }
}
