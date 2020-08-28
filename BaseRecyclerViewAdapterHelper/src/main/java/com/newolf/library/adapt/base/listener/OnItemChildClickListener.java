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
public interface OnItemChildClickListener {
    /**
     * callback method to be invoked when an item child in this view has been click
     *
     * @param adapter  BaseQuickAdapter
     * @param view     The view within the ItemView that was clicked
     * @param position The position of the view int the adapter
     */
    void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position);
}

