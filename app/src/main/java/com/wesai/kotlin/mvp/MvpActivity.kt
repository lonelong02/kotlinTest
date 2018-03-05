package com.wesai.kotlin.mvp

import android.graphics.Point
import android.os.Bundle
import android.view.View
import com.wesai.kotlin.R
import kotlinx.android.synthetic.main.activity_mvp.*

/**
 * Created by long on 2017/12/7.
 *
 * @CreatePresenter(PresenterImpl1::class)
 */

class MvpActivity : IBaseMVPActivity<IViewImpl1, PresenterImpl1>(), IViewImpl1 {
    override fun setViewData(data: String) {
        dataView.setText(data)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)
        setPresenterFactory(object : IPresenterFactory<IViewImpl1, PresenterImpl1> {
            override fun createPresenter(): PresenterImpl1? {
                return PresenterImpl1();
            }
        })
    }

    fun myOnClick(view: View) {
        getPresenterImpl()?.requestData()
    }

}