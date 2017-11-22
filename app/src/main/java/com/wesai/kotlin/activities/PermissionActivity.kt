package com.wesai.kotlin.activities

import android.os.Bundle
import android.view.View
import com.wesai.kotlin.BaseActivity
import com.wesai.kotlin.R
import com.wesai.kotlin.utils.PermissionUtils

class PermissionActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

    }

    fun myOnClick(view: View) {
        when (view.id) {
            R.id.but1 -> {

            }
            R.id.but3 -> {
                if(PermissionUtils.requestSdPermission(this)){
                    toast("已经获取权限")
                }else{
                    toast("暂无权限")
                }

            }
        }

    }

    /*权限监听回调*/
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}