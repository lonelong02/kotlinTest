package com.wesai.kotlin.mvp

import android.os.Bundle

/**
 * Created by long on 2017/12/8.
 */
class BasePresenterProxy<V : IViewInterface, P : IPresenterInterface<V>> : IPresenterProxy<V, P> {

    var factory: IPresenterFactory<V, P>;
    var presenter: P? = null;


    constructor(factory: IPresenterFactory<V, P>) {
        this.factory = factory;
        presenter = getPresenterImpl();
    }

    override fun setPresenterFactory(factory: IPresenterFactory<V, P>) {
        this.factory = factory;
    }

    override fun getFractory(): IPresenterFactory<V, P> {
        return factory;
    }

    override fun getPresenterImpl(): P? {
        return if (presenter != null) presenter else factory?.createPresenter();
    }

    /**
     * 保存数据
     */
    fun onSaveInstanceState(bundle: Bundle?) {
        presenter?.onSaveInstanceState(bundle)
    }

    /**
     * 注册
     */
    fun attachIView(iView: V) {
        presenter?.attachIView(iView)
    }

    /**
     * 解注册
     */
    fun detach() {
        presenter?.detach()
    }
}