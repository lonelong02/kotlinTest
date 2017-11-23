package com.wesai.kotlin.activities

import android.os.Bundle
import android.view.View
import com.wesai.kotlin.BaseActivity
import com.wesai.kotlin.R
import io.reactivex.*
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import java.util.*

class RxJava2Activity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rxjava)
    }

    fun myOnClick(view: View) {
        when (view.id) {
            R.id.but1 -> {
                create();

            }
            R.id.but2 -> {
                operation();
            }
        }
    }

    /**
     * 常用操作符
     */
    fun operation() {
        /*just(参数1,参数2,...):将给定的参数，一次简单的发送出去；若传递一个数组进来，会把数组当作一个简单的item，一次发送出去*/
        /*map(Function<? super T, ? extends R> mapper) :类型1输入类型、类型2输出类型，map函数完成把类型1转换成类型2的操作 */
        Observable.just(1, 5, 9, 12).map { value -> return@map value * 2 }.subscribe { value -> log("值：" + value) }

        /*fromArray(可变数组)：将给定的参数，一次简单的发送出去；若传递一个数组进来，会把数组当作一个简单的item，一次发送出去*/
        Observable.fromArray(10, 50, 99).map { value -> return@map value }.subscribe { value -> log("值：" + value) }

        /*zip():将给定的两组消息源，通过特定组合成新的item，并发送；多数量不一致时，多余的一项不发送*/
        Observable.zip(Observable.just(1, 2, 3), Observable.just("a", "b", "c", "d"), object : BiFunction<Int, String, String> {
            override fun apply(t1: Int, t2: String): String {
                return t1.toString() + t2;
            }
        }).subscribe { value -> log(value) };

        /*concat():将两组数据源合并，然后顺序发射*/
        Observable.concat(Observable.just(1, 5), Observable.just("a", "b")).subscribe { value/*该处的value是Any类型*/ -> log(value.toString()) }

        /*filter:过滤变换，返回true事件继续，返回false事件不在向下传递；*/
        Observable.just(10).filter { value -> return@filter value > 100 }.subscribe { value -> log(value.toString()) }

        /*flatMap(Function<? super T, ? extends ObservableSource<? extends R>> mapper)：输入参数类型，返回ObservableSource<参数类型2>；*/
        Observable.just(100, 200).flatMap { value -> return@flatMap Observable.just(value) }.subscribe { value -> log("类型：" + value::class);log(value.toString()) }

        log("-----------------------------")
        Observable.just("long").subscribeOn(Schedulers.io()).map { value -> log("map");Thread.sleep(1000);return@map "$value am ok" }.flatMap { value -> log("flatMap"); return@flatMap Observable.just(value) }.subscribe { value -> log("subscribe:$value") }

    }

    fun create() {
        /*匿名类写法*/
//        Observable.just("long").map(object : Function<String, Int> {
//            override fun apply(t: String): Int {
//                log(t);
//                return 110
//            }
//        })

        /*lambda 写法*/
//        Observable.just("long").map { str -> log(str); return@map 100 }.subscribe { num -> log("结果：" + num) }

        /* 匿名类-》lambda写法：{ 参数名-》方法体，若有返回，return@标签 返回值 }*/
        /*create<T>() 创建事件源*/
        Observable.create<String> { next -> next.onNext("long") }.map { str -> return@map "My name is $str" }.subscribe { str -> log(str) }
        /*与Observable类似，不过有背压的概念*/
        Flowable.create<String>({ next -> next.onNext("long") }, BackpressureStrategy.BUFFER).map { str -> return@map "My name is $str" }.subscribe { str -> log(str) };

    }
}

