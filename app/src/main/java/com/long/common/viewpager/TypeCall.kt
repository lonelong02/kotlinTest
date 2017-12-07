package com.long.common.viewpager

import android.view.View

/**
 *提供View与绑定数据操作接口
 * Created by long on 2017/11/29.
 */
abstract class TypeCall<T> {
    /**
     * 提供视图
     */
    abstract fun getView(): View;

    /**
     * 绑定数据
     */
    abstract fun onBind(view: View?, mData: T?);
}