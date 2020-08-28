package com.newolf.library.adapt.base.listener;

import androidx.annotation.Nullable;

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
public interface BaseListenerImp {
    /**
     * Register a callback to be invoked when an item in this RecyclerView has
     * been clicked.
     *
     * @param listener The callback that will be invoked.
     */
    void setOnItemClickListener(@Nullable OnItemClickListener listener);

    void setOnItemLongClickListener(@Nullable OnItemLongClickListener listener);

    void setOnItemChildClickListener(@Nullable OnItemChildClickListener listener);

    void setOnItemChildLongClickListener(@Nullable OnItemChildLongClickListener listener);

    void setGridSpanSizeLookup(@Nullable GridSpanSizeLookup spanSizeLookup);
}
