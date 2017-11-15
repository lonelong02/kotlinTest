package com.wesai.kotlin

import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.widget.Toast

abstract class BaseActivity : AppCompatActivity() {

    val Tag: String =this.javaClass.name ?: "kotlinTag";

    fun log(msg: String) {
        log(Tag, msg);
    }

    fun log(tag: String, msg: String) {

        if (TextUtils.isEmpty(tag) || TextUtils.isEmpty(msg)) {
            return
        }
        Log.e(tag, msg);
    }

    fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
