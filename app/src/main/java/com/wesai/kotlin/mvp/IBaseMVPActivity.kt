package com.wesai.kotlin.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by long on 2017/12/7.
 */
abstract class IBaseMVPActivity<V : IViewInterface, P : IPresenterInterface<V>> : AppCompatActivity() {
    //    val pFactory = BasePresenterFactory.getFactory<IViewInterface, IPresenterInterface<IViewInterface>>(javaClass) as IPresenterFactory<V, P>
    val pProxy = BasePresenterProxy(BasePresenterFactory.getFactory<IViewInterface, IPresenterInterface<IViewInterface>>(javaClass) as IPresenterFactory<V, P>)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pProxy?.attachIView(this as V);
    }


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        pProxy?.onSaveInstanceState(outState);
    }


    override fun onDestroy() {
        super.onDestroy()
        pProxy?.detach()
    }
}