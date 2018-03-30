package com.wesai.kotlin.test


/**
 * Created by long on 2017/11/16.
 */

internal class TestJava @JvmOverloads constructor(name: String, age: Int, like: String = "") {
    //    IPresenterFactory<V, P> p = null;
    //
    //    public void test() {
    ////        var pFactory:IPresenterFactory<V, P> =BasePresenterFactory.getFactory(javaClass);
    //
    //        p = BasePresenterFactory.getFactory(getClass());
    //    }
    //
    //    public P getP() {
    //        return p.createPresenter();
    //    }


    constructor(name: String) : this("", 10) {}


}
