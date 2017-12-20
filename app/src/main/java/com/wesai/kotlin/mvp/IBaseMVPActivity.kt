package com.wesai.kotlin.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by long on 2017/12/7.
 */
open class IBaseMVPActivity<V : IViewInterface, P : IPresenterInterface<V>> : AppCompatActivity(), IPresenterProxy<V, P> {
    //    val pFactory = BasePresenterFactory.getFactory<IViewInterface, IPresenterInterface<IViewInterface>>(javaClass) as IPresenterFactory<V, P>
    val pProxy = BasePresenterProxy(if (BasePresenterFactory.getFactory<V, P>(javaClass) != null) BasePresenterFactory.getFactory<V, P>(javaClass) as IPresenterFactory<V, P> else null)


    override fun setPresenterFactory(factory: IPresenterFactory<V, P>) {
        pProxy.setPresenterFactory(factory)
    }

    override fun getFractory(): IPresenterFactory<V, P>? {
        return pProxy.getFractory()
    }

    override fun getPresenterImpl(): P? {
        return pProxy.getPresenterImpl()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
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