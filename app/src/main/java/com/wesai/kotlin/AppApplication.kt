package com.wesai.kotlin

import android.app.Activity
import android.app.Application
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log

/**
 * Created by long on 2017/11/20.
 */
class AppApplication() : Application() {

    companion object {
        var instance: AppApplication? = null;
    }

    var count: Int = 0;
    override fun onCreate() {
        log("onCreate");
        super.onCreate()
        instance = this;
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
        Log.e("AppApplication", str);
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
            }

        })
    }


}