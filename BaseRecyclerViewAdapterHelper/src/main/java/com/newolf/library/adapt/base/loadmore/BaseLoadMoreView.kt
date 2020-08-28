package com.newolf.library.adapt.base.loadmore

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.IntDef
import com.newolf.library.adapt.base.viewholder.BaseViewHolder
import java.lang.annotation.RetentionPolicy

/**
 * ================================================
 *
 * @author : NeWolf
 * @version : 1.0
 * @date :  2020/8/28
 * 描述: 继承此类，实行自定义loadMore视图
 * 历史:<br/>
 * ================================================
 */


abstract class BaseLoadMoreView {

    /**
     * 根布局
     * @param parent ViewGroup
     * @return View
     */
    abstract fun getRootView(parent: ViewGroup): View

    /**
     * 布局中的 加载更多视图
     * @param holder BaseViewHolder
     * @return View
     */
    abstract fun getLoadingView(holder: BaseViewHolder): View

    /**
     * 布局中的 加载完成布局
     * @param holder BaseViewHolder
     * @return View
     */
    abstract fun getLoadComplete(holder: BaseViewHolder): View

    /**
     * 布局中的 加载结束布局
     * @param holder BaseViewHolder
     * @return View
     */
    abstract fun getLoadEndView(holder: BaseViewHolder): View

    /**
     * 布局中的 加载失败布局
     * @param holder BaseViewHolder
     * @return View
     */
    abstract fun getLoadFailView(holder: BaseViewHolder): View

    /**
     * 可重写此方式，实行自定义逻辑
     * @param holder BaseViewHolder
     * @param position Int
     * @param loadMoreStatus LoadMoreStatus
     */
    open fun convert(holder: BaseViewHolder, position: Int,@LoadMoreStatus loadMoreStatus: Int ) {
        when (loadMoreStatus) {
            LoadMoreStatus.Complete -> {
                getLoadingView(holder).isVisible(false)
                getLoadComplete(holder).isVisible(true)
                getLoadFailView(holder).isVisible(false)
                getLoadEndView(holder).isVisible(false)
            }
            LoadMoreStatus.Loading -> {
                getLoadingView(holder).isVisible(true)
                getLoadComplete(holder).isVisible(false)
                getLoadFailView(holder).isVisible(false)
                getLoadEndView(holder).isVisible(false)
            }
            LoadMoreStatus.Fail -> {
                getLoadingView(holder).isVisible(false)
                getLoadComplete(holder).isVisible(false)
                getLoadFailView(holder).isVisible(true)
                getLoadEndView(holder).isVisible(false)
            }
            LoadMoreStatus.End -> {
                getLoadingView(holder).isVisible(false)
                getLoadComplete(holder).isVisible(false)
                getLoadFailView(holder).isVisible(false)
                getLoadEndView(holder).isVisible(true)
            }
        }
    }

    private fun View.isVisible(visible: Boolean) {
        this.visibility = if (visible) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}

@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD, AnnotationTarget.FUNCTION)
@MustBeDocumented
@IntDef(LoadMoreStatus.Complete,LoadMoreStatus.Loading,LoadMoreStatus.Fail,LoadMoreStatus.End)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
annotation class  LoadMoreStatus{
    companion object {
        const val Complete = 0x1001
        const val Loading = 0x1002
        const val Fail = 0x1003
        const val End = 0x1004
    }
}