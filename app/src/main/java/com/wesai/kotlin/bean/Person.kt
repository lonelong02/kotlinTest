package com.wesai.kotlin.bean

/**
 * Created by long on 2017/11/6.
 */
/***
 * 构造方法，可以使用：constructor关键词声明一级 构造函数
 * name: String?  ;表示：可以为null
 *
 * class Person private constructor(name: String?, like: Array<String>):private constructor表示的是私有的构造方法
 *
 * class Person(name: String?, like: Array<String>)：表示constructor关键词可以省略
 *
 * open class Person(name: String?):所有的类默认的都是final的，无法被继承，必须使用open进行修饰
 */
open class Person constructor(temName: String?) {
    var like: Array<String>? = null;
    var name: String? = temName
        get() {//get方法
            return field!!.toUpperCase();
        }
        private set(value) {//set方法,用private修饰，表示只能内部调用
            field = "值：" + value
        }


    var age: Int = 10
        private set
        public get


    /**
     * 初始化代码块；一级构造方法中无法写代码，所以初始化代码可以写在init代码块中
     */
    init {
        this.like = null;
    }


    class TemClass {}

    /**
     * 重载的构造函数  ，this(name)调用一级构造方法
     */
    constructor(name: String?, like: Array<String>) : this(name) {
        this.like = like;
    }

    override fun toString(): String {

        println("name=$name and  like=$like");
        return super.toString()
    }
}