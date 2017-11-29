package com.wesai.kotlin.bean

import android.content.Context

/**
 * Created by long on 2017/11/24.
 */
open class SuperClass() {

    constructor(context: Context) : this() {
    }
}

/*若父类没有定义任何构造方法，会默认存在一个无参数的构造方法*/
class SonClass : SuperClass {
    constructor(context: Context) : super(context) {

    }
}