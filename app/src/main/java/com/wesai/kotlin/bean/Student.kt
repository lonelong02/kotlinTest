package com.wesai.kotlin.bean

/**
 * Created by long on 2017/10/30.
 */

class Student(name: String) : Person(name) {
    companion object {
        /*定义类似static方法*/
        @JvmStatic
        fun staticFun() {
        }
    }//给类定义一个伴生对象


}
