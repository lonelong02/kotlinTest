package com.wesai.kotlin.services

import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Binder
import android.os.IBinder
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast

/**
 * Created by long on 2017/11/30.
 */
class SuspendService : Service() {
    override fun onBind(intent: Intent?): IBinder {
        return MyBind();
    }

    class MyBind : Binder() {
    }


    /*Service的onCreate方法*/
    override fun onCreate() {
        super.onCreate()
        var winService = getSystemService(Context.WINDOW_SERVICE) as WindowManager;
        var view = View(this);
        view.setBackgroundColor(Color.GREEN);

        var params = WindowManager.LayoutParams();
        /*TYPE_TOAST：不需要权限，但是在部分手机上有问题；TYPE_SYSTEM_ALERT需求权限，且在23之后需要动态的申请权限*/
//        params.type = WindowManager.LayoutParams.TYPE_TOAST
        params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT

        /*设置各种属性：FLAG_NOT_FOCUSABLE悬浮所有的上面，可以继续操作其他的应用或视图*/
        params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE

        /*位置与宽高*/
        params.gravity = Gravity.LEFT or Gravity.TOP;
        params.x = 100
        params.y = 100
        params.width = 300
        params.height = 400
        view.setOnClickListener { view ->
            Toast.makeText(applicationContext, "点击悬浮框", Toast.LENGTH_LONG).show();
        }
        //添加显示
        winService.addView(view, params);
    }


}