package com.wesai.kotlin.bean

/**
 * Created by long on 2017/11/13.
 */
interface InterfaceClass {
    /*接口中可以定义属性，但是属性不能在接口中初始化，需要在子类中初始化*/
    /*      var age : Int = 100;*/
    var age: Int;

    /*接口方法*/
    fun say();

    /*接口中，可以定义实现方法，且可以在方法体中调用接口中定义的未实现的方法与属性*/
    fun sing() {
        println("我是接口InterfaceClass中定义的 $age");
        /*接口方法*/
        say();
    }
}

interface InterfaceB {
    fun sing() {
        println("我是接口InterfaceB中定义的 ");
    };
}

/*子类必须初始化接口中定义的属性*/
class InterfaceImpl(override var age: Int) : InterfaceClass, InterfaceB {
    override fun say() {
    }

    /*实现类可以重写父类方法*/
    override fun sing() {
        /*调用InterfaceClass接口的方法*/
        super<InterfaceClass>.sing()
        /*调用InterfaceB接口的方法*/
        super<InterfaceB>.sing()
    }
}