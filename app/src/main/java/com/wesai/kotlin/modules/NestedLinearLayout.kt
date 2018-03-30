package com.wesai.kotlin.modules

import android.content.Context
import android.support.v4.view.NestedScrollingParent
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.wesai.kotlin.R

/**
 * Created by long on 2017/11/30.
 */
class NestedLinearLayout : LinearLayout, NestedScrollingParent {
    var tag = "NestedLinearLayout";
    var headerH: Int;

    constructor(context: Context) : super(context) {
        log("constructor1");
        headerH = context.resources.getDimensionPixelOffset(R.dimen.nested_header_height)
    }

    constructor(context: Context, arr: AttributeSet) : super(context, arr) {
        log("constructor2");
        headerH = context.resources.getDimensionPixelOffset(R.dimen.nested_header_height)
    }

    fun log(msg: String) {
        Log.e(tag, msg)

    }

    override fun onNestedScrollAccepted(child: View, target: View, axes: Int) {
        log("onNestedScrollAccepted");
    }

    override fun onStartNestedScroll(child: View, target: View, axes: Int): Boolean {
        var result = ViewCompat.SCROLL_AXIS_VERTICAL and axes != 0;
        log("onStartNestedScroll=" + result)
        return result
    }

    override fun onNestedFling(target: View, velocityX: Float, velocityY: Float, consumed: Boolean): Boolean {
        var result = true;
        log("onStartNestedScroll=" + result)
        return result
    }

    override fun onNestedPreFling(target: View, velocityX: Float, velocityY: Float): Boolean {
        var result = false;
        log("onNestedPreFling=" + result)
        return result
    }

    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray) {
        log("onNestedPreScroll;dx=$dx dy=$dy scrollY=$scrollY  consumed[1]=${consumed[1]}")

        if (dy > 0 && scrollY < headerH) {
            var mY = Math.min(dy, headerH - scrollY);
            scrollBy(0, mY)
            consumed[1] = mY
        }

        if (dy < 0 && scrollY >= 0 && !target.canScrollVertically(-1)) { //!target.canScrollVertically(-1)  父View是否可以向下（-1）滑动了
            var mY = -Math.min(Math.abs(dy), scrollY)
            scrollBy(0, mY)
            consumed[1] = mY
        }
        log("onNestedPreScroll end;dx=$dx dy=$dy scrollY=$scrollY  consumed[1]=${consumed[1]}")

    }


    override fun getNestedScrollAxes(): Int {
        log("getNestedScrollAxes; ${ViewCompat.SCROLL_AXIS_VERTICAL}")
        return 0
    }

    override fun onNestedScroll(target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int) {
        log("onNestedScroll;dxConsumed=$dxConsumed dyConsumed=$dyConsumed dxUnconsumed=$dxUnconsumed dyUnconsumed=$dyUnconsumed")
    }

    override fun onStopNestedScroll(target: View) {
        log("onStopNestedScroll;")
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        /*解决滑动后 RecyclerView向上移动的问题； 重新设置RecyclerView的高度*/
        getChildAt(2).getLayoutParams().height = measuredHeight - getChildAt(1).measuredHeight;
//        setMeasuredDimension(measuredWidth, measuredHeight)
    }
}
