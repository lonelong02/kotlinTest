package com.wesai.kotlin.activities

import android.os.Bundle
import com.wesai.kotlin.BaseActivity
import com.wesai.kotlin.R
import kotlinx.android.synthetic.main.activity_air.*

class AirPurgeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_air)
        but1.setOnClickListener { view ->
            airView.startAnim()

        }

    }
}