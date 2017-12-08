package com.wesai.kotlin.mvp

/**
 * Created by long on 2017/12/8.
 */
interface IPresenterProxy<V : IViewInterface, P : IPresenterInterface<V>> {

    fun setPresenterFactory(factory: IPresenterFactory<V, P>);

    fun getFractory(): IPresenterFactory<V, P>;

    fun getPresenterImpl(): P?;

}