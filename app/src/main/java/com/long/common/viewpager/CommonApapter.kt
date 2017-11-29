package com.long.common.viewpager

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup

/**
 * Created by long on 2017/11/29.
 */
class CommonApapter<T> : PagerAdapter {
    var data: List<T>;
    var typeCall: TypeCall<T>;
    var views: ArrayList<View> = arrayListOf();

    constructor(data: List<T>, call: TypeCall<T>) : super() {
        this.data = data;
        this.typeCall = call;
    }

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
        container?.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        //获取视图
        var view = getView(position);
        //视图绑定
        typeCall.onBind(view, data.get(position));
        container?.addView(view);
        return view;
    }

    override fun getCount(): Int {
        return data.size;
    }

    /**
     * 获取View
     */
    private fun getView(position: Int): View {
        var view = if (views.size > position) views.get(position) else null;
        if (view == null) {
            view = typeCall.getView();
            views.add(view);
        }
        return view;

    }


}