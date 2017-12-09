package com.wesai.kotlin.mvp

import android.os.Bundle

/**
 * Created by long on 2017/12/8.
 */
class BasePresenterProxy<V : IViewInterface, P : IPresenterInterface<V>> : IPresenterProxy<V, P> {

    private var factory: IPresenterFactory<V, P>?;
    private var presenter: P? = null;


    constructor(factory: IPresenterFactory<V, P>?) {
        this.factory = factory;
    }

    override fun setPresenterFactory(factory: IPresenterFactory<V, P>) {
        this.factory = factory;
    }

    override fun getFractory(): IPresenterFactory<V, P>? {
        return factory;
    }

    override fun getPresenterImpl(): P? {
        if (presenter == null) {
            presenter = factory?.createPresenter();
        }
        return presenter
    }

    /**
     * 保存数据
     */
    fun onSaveInstanceState(bundle: Bundle?) {
        getPresenterImpl()?.onSaveInstanceState(bundle)
    }

    /**
     * 注册
     */
    fun attachIView(iView: V) {
        getPresenterImpl()?.attachIView(iView)
    }

    /**
     * 解注册
     */
    fun detach() {
        getPresenterImpl()?.detach()
    }
}