package com.wesai.kotlin.mvp

import android.os.Bundle
import android.view.View
import com.wesai.kotlin.R
import kotlinx.android.synthetic.main.activity_mvp.*

/**
 * Created by long on 2017/12/7.
 */
class MvpActivity : IBaseMVPActivity<IViewImpl1, PresenterImpl1>(), IViewImpl1 {
    override fun setViewData(data: String) {
        dataView.setText(data)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)
    }

    fun myOnClick(view: View) {
        presenter.requestData()
    }


    override fun createPresenter(): PresenterImpl1 {
        return PresenterImpl1()
    }

}