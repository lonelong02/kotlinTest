package com.wesai.kotlin.activities

import android.os.Bundle
import android.os.Handler
import com.wesai.kotlin.BaseActivity
import com.wesai.kotlin.R
import kotlinx.android.synthetic.main.activity_adapter.*

/**
 * 屏幕适配方案
 */
class AdaptiveActivity : BaseActivity() {

    var mHandler = Handler();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adapter)
        mHandler.post { log("text1.w=${text1.width} h=${text1.height}  t2=${text2.width}   imageView.w=${imageView.width} h=${imageView.height}") }
    }
}
