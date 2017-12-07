package com.wesai.kotlin.mvp

/**
 *
 * Created by long on 2017/12/7.
 */
abstract class IPresenterInterface<V : IViewInterface> {

   protected var iView: V? = null;

    /**
     * 注册
     */
    fun attachIView(iView: V) {
        this.iView = iView;
    }

    /**
     * 解注册
     */
    fun detach() {
        iView = null
    }


}