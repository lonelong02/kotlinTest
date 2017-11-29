package com.long.common.viewpager

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet

/**
 * Created by long on 2017/11/29.
 */
class CommonViewPager : ViewPager {
    constructor(context: Context) : super(context) {}
    constructor(context: Context, attr: AttributeSet) : super(context, attr) {
    }

    fun <T> setData(mData: List<T>, typeCall: TypeCall<T>) {
        adapter = CommonApapter(mData, typeCall);
    }
}