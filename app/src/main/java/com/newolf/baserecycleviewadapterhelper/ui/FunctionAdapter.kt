package com.newolf.baserecycleviewadapterhelper.ui

import com.newolf.baserecycleviewadapterhelper.demo.R
import com.newolf.library.adapt.base.BaseQuickAdapter
import com.newolf.library.adapt.base.viewholder.BaseViewHolder

/**
 * ================================================
 *
 * @author : NeWolf
 * @version : 1.0
 * @date :  2020/9/1
 * 描述:
 * 历史:<br/>
 * ================================================
 */
class FunctionAdapter() : BaseQuickAdapter<String, BaseViewHolder>(layoutResId = R.layout.adapter_function) {
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.tvItem,item)
    }
}