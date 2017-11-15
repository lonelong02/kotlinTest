package com.wesai.kotlin.bean

/**
 * Created by long on 2017/11/12.
 */
abstract class AbstractClass(str: String?) {
    /**
     * 抽象方法
     */
    abstract fun say(str: String);


    /**
     * 实例方法
     */
    fun ring() {}
}
