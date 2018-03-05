package com.wesai.kotlin

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.widget.Toast

abstract class BaseActivity : AppCompatActivity() {

    companion object {
        fun toast(context: Context, msg: String) {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
        }

        fun log(msg: String) {
            log(this.javaClass.name, msg);
        }

        fun log(tag: String, msg: String) {
            if (TextUtils.isEmpty(tag) || TextUtils.isEmpty(msg)) {
                return
            }
            Log.e(tag, msg);
        }
    }

    val Tag: String = this.javaClass.name ?: "kotlinTag";

    fun log(msg: String) {
        log(Tag, msg);
    }


    fun toast(msg: String) {
        toast(this, msg)
    }
}
