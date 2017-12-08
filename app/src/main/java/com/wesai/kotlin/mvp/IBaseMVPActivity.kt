package com.wesai.kotlin.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by long on 2017/12/7.
 */
abstract class IBaseMVPActivity<V : IViewInterface, P : IPresenterInterface<V>> : AppCompatActivity() {
    lateinit var presenter: P;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter();
        presenter?.attachIView(this as V);
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter?.detach()
    }

    abstract fun createPresenter(): P;
}