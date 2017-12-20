package com.wesai.kotlin.iterator

import android.util.Log
import java.util.*

/**
 * Created by long
 * on 2017/12/19.
 */
class Test1 {

    fun main() {
        test();
    }

    fun test() {
        var arr1 = IntArray(3, { i -> i * 3 });
        /*最后一项*/
        arr1.last();

        /*循环*/
        arr1.forEach { item -> log("数组value=$item"); }
        pr();

        var list = arrayListOf<Int>();

        /*
        * toMutableList();将不可变集合转换成可变集合
        * */
//        var list = listOf<Int>()
//        list.toMutableList()

        /*
        * 将数组添加到List中
        * */
//        list.addAll(arr1.asList());

        /*
        * arr1.distinctBy { item -> return@distinctBy 100 }；通过返回的值作为key，返回key不相同的List对象；返回长度为1的List
        * */
//        list.addAll(arr1.distinctBy { item -> return@distinctBy 100 });

        for (value in list) {
            log("value=${value}");
        }

//        var map = hashMapOf<Int, String>();

        var myList = MyList(5);
        for (value in myList) {
            log("myList:value=${value}");
        }

    }

    fun log(msg: String) {
        Log.e("tag", msg);
    }

    fun pr() {
        Log.e("tag", "--------------------------------------------------------------------------------");
    }
}