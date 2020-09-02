package com.newolf.baserecycleviewadapterhelper.ui

import android.icu.text.CaseMap
import com.newolf.baserecycleviewadapterhelper.demo.R
import com.newolf.baserecycleviewadapterhelper.demo.entry.FunctionEntry
import com.newolf.library.adapt.base.BaseMultiItemQuickAdapter
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
class MultiDataAdapter(data: List<FunctionEntry> ):BaseMultiItemQuickAdapter<FunctionEntry,BaseViewHolder>( data.toMutableList()
){
    init {
        addItemType(FunctionEntry.TYPE_TEXT, R.layout.adapter_multi_data_text)
        addItemType(FunctionEntry.TYPE_IMAGE, R.layout.adapter_multi_data_image)
    }

    override fun convert(holder: BaseViewHolder, item: FunctionEntry) {
        when(item.itemType){
            FunctionEntry.TYPE_TEXT->holder.setText(R.id.tvItem,item.name)
            FunctionEntry.TYPE_IMAGE->holder.setText(R.id.tvItem,item.name)

        }
    }
}