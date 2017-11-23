package com.wesai.kotlin.modules

import android.content.Context
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CoordinatorLayout
import android.util.AttributeSet
import android.view.View
import com.wesai.kotlin.R

/**
 * Created by long on 2017/11/23.
 */
class SuspendBehavior() : CoordinatorLayout.Behavior<View>() {

    var defHeight: Float = 0.0f;

    constructor(context: Context) : this(context, null) {

    }

    constructor(context: Context, att: AttributeSet?) : this() {
        defHeight = context.resources.getDimension(R.dimen.toolbar_height)
    }

    override fun layoutDependsOn(parent: CoordinatorLayout?, child: View?, dependency: View?): Boolean {
        return dependency is AppBarLayout;
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout?, child: View?, dependency: View?): Boolean {

        var appBar = dependency as AppBarLayout;
        var total = appBar.totalScrollRange;
        if (total + appBar.y > child!!.height / 2) {
            child.translationY = appBar.height + appBar.y - child!!.height / 2;
//            child.translationY = total + appBar.y + defHeight - child!!.height / 2;
        } else {
            child.translationY = defHeight;
        }


        return super.onDependentViewChanged(parent, child, dependency)
    }


}