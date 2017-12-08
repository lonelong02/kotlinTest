package com.wesai.kotlin.mvp

import android.os.Bundle

/**
 *
 * Created by long on 2017/12/7.
 */
abstract class IPresenterInterface<V : IViewInterface> {

    protected var iView: V? = null;


    /**
     *创建时回调
     */
    fun onCreatePresenter() {

    }

    /**
     * 保存数据
     */
    fun onSaveInstanceState(bundle: Bundle?) {

    }

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