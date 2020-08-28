package com.newolf.library.adapt.base.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

/**
 * ================================================
 *
 * @author : NeWolf
 * @version : 1.0
 * @date :  2020/8/28
 * 描述: 扩展方法，用于获取View
 * 历史:<br/>
 * ================================================
 */
fun ViewGroup.getItemView(@LayoutRes layoutResId: Int): View {
    return LayoutInflater.from(this.context).inflate(layoutResId, this, false)
}