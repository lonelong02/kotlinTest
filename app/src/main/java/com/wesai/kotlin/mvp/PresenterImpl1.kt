package com.wesai.kotlin.mvp

import android.os.Handler

/**
 * Created by long on 2017/12/7.
 */
class PresenterImpl1 : IPresenterInterface<IViewImpl1>() {

    var mFactory = DataFactory.getInstance();

    fun requestData() {
        iView?.setViewData("加载ing")
        Handler().postDelayed({
            iView?.setViewData(mFactory!!.loadData())
        }, 1000);
    }


}