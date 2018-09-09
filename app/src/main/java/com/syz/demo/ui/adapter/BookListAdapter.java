package com.syz.demo.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.syz.demo.R;
import com.syz.demo.databinding.ItemBookBinding;
import com.syz.demo.mvp.model.bean.BookListBean;

import java.util.List;

/**
 * Created by shiyuzhe on 2018/9/9.
 * WeChat:18091664559
 * Description:
 */
public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ItemHolder> {
    private List<BookListBean> mDatas;

    public void setmDatas(List mDatas) {
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        ViewDataBinding binding = DataBindingUtil.inflate(inflater, layoutId, parent, false);
//        ViewHolder viewHolder = new ViewHolder(binding.getRoot());
//        viewHolder.setBinding(binding);
//        return viewHolder;
        ItemBookBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_book, parent, false);
        return new ItemHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {
        itemHolder.getBinding().setItem(mDatas.get(i));
        itemHolder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        private ItemBookBinding binding;

        public ItemBookBinding getBinding() {
            return binding;
        }

        public ItemHolder(ItemBookBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
