package com.zzc.chaobaselibrary.utils

import android.app.Activity
import android.app.Application
import android.os.Bundle
import java.util.*

object ActivityUtil {

    //stack栈，后进先出
    private val activityStack = Stack<Activity>()

    //activity的生命周期回调，要求API14+(安卓4.0)
    private val instance = MyActivityLifecycleCallbacks()

    val activityLifecycleCallbacks: Application.ActivityLifecycleCallbacks
        get() = instance

    /**
     * 获取当前栈顶Activity
     */
    val currentActivity:Activity?
    get() {
        var activity:Activity?=null
        if(!activityStack.isEmpty()) activity= activityStack.peek()
        return activity
    }

    /**
     * 获取当前Activity的名字
     */
    val currentActivityName:String
    get() {
        val activity= currentActivity
        var name=""
        if(activity!=null){
            name=activity.componentName.className
        }
        return name
    }


    private class MyActivityLifecycleCallbacks : Application.ActivityLifecycleCallbacks {
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            activityStack.remove(activity)
            activityStack.push(activity)
        }

        override fun onActivityStarted(activity: Activity) {
        }

        override fun onActivityResumed(activity: Activity) {
        }

        override fun onActivityPaused(activity: Activity) {
        }

        override fun onActivityStopped(activity: Activity) {
        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        }

        override fun onActivityDestroyed(activity: Activity) {
            activityStack.remove(activity)
        }

    }
}