package com.wesai.kotlin.test;


import android.content.Context;
import android.support.v4.view.NestedScrollingParent;
import android.widget.LinearLayout;


/**
 * Created by long on 2017/11/16.
 */

class TestJava extends LinearLayout implements NestedScrollingParent {

    public TestJava(Context context) {
        super(context);
        t(null);

    }

    public <T> void t(Class<T> mClass) {

    }
}
