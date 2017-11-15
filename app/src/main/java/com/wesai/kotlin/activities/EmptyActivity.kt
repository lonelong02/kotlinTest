package com.wesai.kotlin.activities

import android.os.Bundle
import com.wesai.kotlin.BaseActivity
import com.wesai.kotlin.R

class EmptyActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)
    }
}
