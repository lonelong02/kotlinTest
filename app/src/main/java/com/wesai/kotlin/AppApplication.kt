package com.wesai.kotlin

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.graphics.Point
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import com.taobao.sophix.PatchStatus
import com.taobao.sophix.SophixManager

/**
 * Created by long on 2017/11/20.
 */
class AppApplication() : Application() {
    var tag = "AppApplicationDebug";

    companion object {
        var instance: AppApplication? = null;
    }

    override fun attachBaseContext(base: Context?) {
        SophixManager.getInstance().setContext(this).setAppVersion(getAppVersion()).setAesKey("").setEnableDebug(true)
                .setPatchLoadStatusStub { mode, code, info, handlePatchVersion ->
                    // 补丁加载回调通知
                    if (code == PatchStatus.CODE_LOAD_SUCCESS) {
                        // 表明补丁加载成功
                        log("表明补丁加载成功");
                    } else if (code == PatchStatus.CODE_LOAD_RELAUNCH) {
                        // 表明新补丁生效需要重启. 开发者可提示用户或者强制重启;
                        // 建议: 用户可以监听进入后台事件, 然后调用killProcessSafely自杀，以此加快应用补丁，详见1.3.2.3
                        log("表明新补丁生效需要重启. 开发者可提示用户或者强制重启;");
                    } else {
                        // 其它错误信息, 查看PatchStatus类说明
                        log("其它错误信息, 查看PatchStatus类说明");
                    }

                }.initialize();
        super.attachBaseContext(base)
    }

    fun getAppVersion(): String {
        var appVersion: String
        try {
            appVersion = this.packageManager.getPackageInfo(this.packageName, 0).versionName
        } catch (e: Exception) {
            appVersion = "1.0.0"
        }

        return appVersion;
    }

    var count: Int = 0;
    override fun onCreate() {
        log("onCreate");
        super.onCreate()
        SophixManager.getInstance().queryAndLoadNewPatch();
        instance = this;
        resetDensity(this, 1334.0f);
        countActivity();
    }


    override fun onConfigurationChanged(newConfig: Configuration?) {
        log("onConfigurationChanged");
        super.onConfigurationChanged(newConfig)
    }

    override fun onTerminate() {
        log("onTerminate");
        super.onTerminate()
    }

    fun log(str: String) {
        Log.e(tag, str);
    }

    /*在API-14中被引入*/
    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Log.e("AppApplication", "onTrimMemory:" + level);
        if (level <= 20) {
            Log.e("AppApplication", "当前应用已经进入后台进程；无任何界面可以见到");
        }
    }

    /***
     * 注册Activity生命周期回调来判断应用是否在前台
     */
    fun countActivity() {
        count = 0;
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity?) {
            }

            override fun onActivityResumed(activity: Activity?) {
            }

            override fun onActivityStarted(activity: Activity?) {
                count++;
                log("activity:size=" + count)
            }

            override fun onActivityStopped(activity: Activity?) {
                count--;
                log("activity:size=" + count)
                /*count<=0;表示当前进程已经进入后台进程*/
            }

            override fun onActivityDestroyed(activity: Activity?) {
            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
            }

            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                //所有机型适配;思路：重新设置DisplayMetrics.xdpi的属性（TypedValue.applyDimension方法）；
                if (activity != null)
                    resetDensity(activity, 1080.0f);
            }

        })
    }


    /**
     * 重新设置
     * 所有机型适配;思路：重新设置DisplayMetrics.xdpi的属性（TypedValue.applyDimension方法）；
     */
    fun resetDensity(context: Context, designWidth: Float) {
        //value * metrics.xdpi * (1.0f/72);
        var size = Point()
        var wManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        wManager.defaultDisplay.getSize(size)
        context.resources.displayMetrics.xdpi = size.x / designWidth * 72;
    }


}