package com.wesai.kotlin.bean

/**
 * Created by long on 2017/11/12.
 */

class AbstractImpl : AbstractClass("str=AbstractImpl") {
    var name = "long";
    override fun say(str: String) {
        println(str)
    }

    /*嵌套类*/
    class QtClass {
        fun sayGood(): String {
            println("嵌套类，无法使用外部类的属性与方法;")
            return "嵌套 good";
        }
    }

    /*内部类*/
   open inner class InterClass {
        fun sayGood(): String {
            say("内部类，可以使用外部类的属性与方法;${say(name)}")
            return name + " good";
        }

        /**/
        fun call(): String {
            return "call";
        }
    }

    fun setInterClass(inter: InterClass) {}

    /*设置匿名类*/
    fun setCallBack(back: CallBack) {}

    interface CallBack {
        fun back();
    }
}

