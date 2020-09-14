package com.newolf.library.adapt.base.loadmore

import android.view.View
import android.view.ViewGroup
import com.newolf.library.adapt.base.R
import com.newolf.library.adapt.base.utils.getItemView
import com.newolf.library.adapt.base.viewholder.BaseViewHolder

/**
 * ================================================
 *
 * @author : NeWolf
 * @version : 1.0
 * @date :  2020/9/14
 * 描述:
 * 历史:<br/>
 * ================================================
 */
class DefaultLoadMoreView: BaseLoadMoreView() {
    override fun getRootView(parent: ViewGroup): View =
        parent.getItemView(R.layout.newolf_brvah_default_load_more)

    override fun getLoadingView(holder: BaseViewHolder): View =
        holder.getView(R.id.load_more_loading_view)

    override fun getLoadComplete(holder: BaseViewHolder): View =
        holder.getView(R.id.load_more_load_complete_view)

    override fun getLoadEndView(holder: BaseViewHolder): View =
        holder.getView(R.id.load_more_load_end_view)

    override fun getLoadFailView(holder: BaseViewHolder): View =
        holder.getView(R.id.load_more_load_fail_view)
}