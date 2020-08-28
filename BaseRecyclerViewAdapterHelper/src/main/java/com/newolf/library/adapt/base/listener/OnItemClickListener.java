package com.newolf.library.adapt.base.listener;

import android.view.View;

import androidx.annotation.NonNull;

import com.newolf.library.adapt.base.BaseQuickAdapter;

/**
 * ================================================
 *
 * @author : NeWolf
 * @version : 1.0
 * @date :  2020/8/27
 * 描述:
 * 历史:<br/>
 * ================================================
 */
public interface OnItemClickListener {
    /**
     * Callback method to be invoked when an item in this RecyclerView has
     * been clicked.
     *
     * @param adapter  the adapter
     * @param view     The itemView within the RecyclerView that was clicked (this
     *                 will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     */
    void onItemClick(@NonNull BaseQuickAdapter<?,?> adapter, @NonNull View view, int position);
}
