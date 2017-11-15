package com.wesai.kotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.ArraySet
import android.util.Log
import android.view.View
import android.widget.Toast
import com.wesai.kotlin.activities.AirPurgeActivity
import com.wesai.kotlin.bean.AbstractImpl
import com.wesai.kotlin.bean.Person
import com.wesai.kotlin.bean.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        but1.setOnClickListener({ view ->
            Toast.makeText(this, "计算为：" + sun(1, 2), Toast.LENGTH_LONG).show();
//            range();
//            newClass();
//            testArray();
            extendObject()
//            interClass();
//            testOther();
//            testRun();


        })
    }

    /*点击事件*/
    fun myOnClick(view: View) {
        when (view.id) {
            R.id.but2 -> {
                startActivity(Intent(this, AirPurgeActivity::class.java))
            }
        }

    }

    fun testRun() {
        /* run(匿名函数) ;匿名函数作为run方法的参数*/
        run({
            println("这个kotlin.run函数")
        })
        var i = run {
            var t = 10;
            return@run t
        }
        var j = run tem@ {
            return@tem 100
        }
        println("匿名函数$i  j=$j")

        /*forEach(匿名函数)  */
        val arr = intArrayOf(1, 3, 5, 0, 7, 9, 13)
        arr.forEach(fun(value) {
            println("值：$value");
        })

        println("{}匿名函数模式");
        arr.forEach {
            println("值：$it");
        }
        fg();

        var tem = run({
            arr.forEach li@ {
                if (it == 0) return@li //返回到标签li位置，继续循环
                if (it == 9) return@run it;//返回整个run函数，返回值为9
                println("run：it= $it");
            }
        })
        println("tem：$tem"); //9

        fg()

        /*匿名函数可以作为一个变量保存*/
        var c = end@ { count: Int ->
            return@end count + 3
        }
        println("c：${c(4)}"); //调用匿名函数c


        fg();

        /*匿名函数嵌套*/
        var f = f1@ {
            println("1")
            return@f1 f2@ {
                println("2")
                return@f2 f3@ {
                    println("3")
                    return@f3 3;
                }
            }
        }
        println("f=${f}")// f=Function0<kotlin.jvm.functions.Function0<? extends kotlin.jvm.functions.Function0<? extends java.lang.Integer>>>
        println("f()=${f()}")//f()=Function0<kotlin.jvm.functions.Function0<? extends java.lang.Integer>>
        println("f()()=${f()()}")// f()()=Function0<java.lang.Integer>
        println("f()()()=${f()()()}")//f()()()=3
    }

    fun fg() {
        println("------------------------------------------------------------")
    }

    fun testOther() {
        var name: String? = null;
        var nameTem: String? = "long";
        nameTem = name?.toUpperCase();
        println("name=" + name);
        println("nameTem=" + nameTem);


        println("@字符标签test");
        /*@字符  标签*/
        tem@ for (i in 1..3) {
            for (j in 1..3) {
                if (j == 2) {
                    break@tem
                }
                println("i=" + i + ";j=" + j)
            }
        }


        var arr = intArrayOf(1, 3, 6, 0, 7, 9);
        arr.forEach li@ {
            if (it == 0) {
                println("退出");
                return@li;
            }
            print(it);
        }
        println("@字符标签end");

        arr.forEach(fun(value: Int) {
            if (value == 0) return
            print(value);
        })
    }

    fun interClass() {


    }

    /*扩展Student类 */
    fun Student.say() {
        println("扩展的Student.say方法 $name   age=${this.age}")
    }

    /*对伴生对象的扩展，使用类名调用；类似于static方法与属性*/
    fun Student.Companion.newF() {
        println("扩展的Person的伴生对象 Student.Companion.newF")
    }

    fun Person.say() {
        println("扩展的Person.say方法 $name   age=${this.age}")
    }


    fun f(ob: Person) {
        ob.say();
    }

    fun extendObject() {
        var p = Person("long")
        //调用扩展的方法
//        p.say();
        f(p);
        p = Student("Student:long");
//        p.say()
        f(p);
        println(null.toString());
        Student.newF();

    }

    /*扩展所有类的toString()方法*/
    fun Any?.toString(): String {
        if (this == null) {
            return "my null";
        }
        return toString()
    }

    /**
     * 无返回值的函数
     */
    fun myLog(msg: String): Unit {
        println(msg);
    }

    /**
     * 私有方法  返回值为Int类型的函数
     */
    private fun sun(a: Int, b: Int): Int {
        return a + b;
    }

    /**
     * 可变参数 函数
     */
    fun sun(vararg nums: Int): Int {
        var num = 0;
        for (row in nums) {
            num += row;
        }
        return num;
    }

    /**
     *String?  返回值可以为null
     */
    fun toStr(num: Int): String? {
        return null;
    }

    /**
     * public方法无返回值的函数
     */
    fun sum(a: Int, b: String) {

    }

    fun log(str: String) {
        Log.e("kotlinTest", str);
    }

    /**
     * 字符串模板
     */
    fun str() {
        var a = 1;
        var s = "a = $a";
        log("${s.replace("=", " ***** ")}");
    }

    /**
     * null检查机制
     */
    fun nullTest() {
        //变量可以为null
        var name: String? = "long";
        //若name为null，会抛出空指针异常
        var like = name!!;
        //若like为null,返回10
        var age = like ?: 10;
    }


    /**
     * 区间循环
     */
    fun range() {
        for (i in 4..1) {
            log("值$i");
        }
    }

    /**
     * 类声明与描述
     */
    fun newClass() {
        var array = Array(4, { i -> ((i * 3).toString()) });
        var person = Person("long", array);
        var impl = AbstractImpl();
        /*内部类使用*/
        AbstractImpl().InterClass().sayGood();
        var result = AbstractImpl().InterClass().call();
        AbstractImpl().setInterClass(AbstractImpl().InterClass())

        /*嵌套类使用*/
        AbstractImpl.QtClass().sayGood();

        /*匿名类使用，使用关键词object ：类名 */
        AbstractImpl().setCallBack(object : AbstractImpl.CallBack {
            override fun back() {
                println("我是匿名类的实现")
            }
        })


        println(person);
    }

    /**
     * 数组相关
     */
    fun testArray() {

        /*    数组声明*/
        var arr: Array<String> = arrayOf("1", "4");

        /*使用构造方法声明，长度 与 init方法*/
        var arrIntF = Array(5, { i -> i * 2 });

        /*声明一个空数组*/
        var arrEmpty = emptyArray<String>();

        /* 声明固定长度的数组*/
        var arrLen = arrayOfNulls<Int>(10);


        /*Float类型数组,其他的基本类型类似： BooleanArray 、ByteArray、ShortArray、IntArray、LongArray、FloatArray、DoubleArray*/
        var arrFloat: FloatArray = floatArrayOf(1.0f, 3.0f);

        /* Int类型数组声明*/
        var arrInt: IntArray = intArrayOf(10, 3, 6, 2, 7);

        log("长度：" + arrFloat.size.toString());

        /*for循环   break可以跳出循环 */
        for (value in arrInt) {
            log("数组值=$value");
            break
        }

        for (i in arrInt.indices) {
            log("数组下标取值=${arrInt[i]}");
        }

    }

    fun testList() {

        /* 声明一个List对象*/
        var list = listOf<Int>();
        /*listOf声明出来的对象是只读的，若要操作，需要转换为其他类型*/
        (list as ArrayList).add(1)
        /*可变集合*/
        var arrList = arrayListOf<Int>();
        arrList.add(100)


        /*声明一个Set集合*/
        var setTem = setOf<String>();
        (setTem as ArraySet).add("newRow");
        var arraySet = hashSetOf<String>();
        arraySet.add("first");


        /*Map集合使用*/
        var mapTem = mapOf<String, Int>();
        (mapTem as HashMap).put("value", 1);
        var hashMap = hashMapOf<String, Boolean>();
        hashMap.put("value", false);
    }
}
