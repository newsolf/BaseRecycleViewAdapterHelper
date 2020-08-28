package com.newolf.library.adapt.base.listener;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;

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
public interface GridSpanSizeLookup {

    int getSpanSize(@NonNull GridLayoutManager gridLayoutManager, int viewType, int position);
}
