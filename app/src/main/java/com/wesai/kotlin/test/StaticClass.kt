package com.wesai.kotlin.test

import android.util.Log

/**
 * Created by long on 2017/11/16.
 */
/*单例类，该类只存在唯一的实例;自己不能实例化,所有的属性与方法都通过类名调用*/
object StaticClass {
    var Tag = "JavaTest"

    /*初始化代码*/
    init {

    }
    /*实例方法*/
    fun fun1() {
        Log.e(Tag, "fun1");
    }

}
