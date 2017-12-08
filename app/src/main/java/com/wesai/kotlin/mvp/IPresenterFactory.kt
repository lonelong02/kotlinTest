package com.wesai.kotlin.mvp

/**
 * Created by long on 2017/12/8.
 */
interface IPresenterFactory<V : IViewInterface, P : IPresenterInterface<V>> {
    fun createPresenter(): P?;
}