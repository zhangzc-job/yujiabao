package com.zzc.chaobaselibrary.utils

import android.app.Activity
import android.app.Application
import com.zzc.chaobaselibrary.view.ZLoadingDialog

object ZUtils {

    lateinit var mApp: Application
    private var zLoadingDialog: ZLoadingDialog? = null

    fun init(app: Application) {
        mApp = app
        app.registerActivityLifecycleCallbacks(ActivityUtil.activityLifecycleCallbacks)
    }

    fun getApp(): Application {
        if (this::mApp.isInitialized) {
            return mApp
        } else {
            throw UninitializedPropertyAccessException("ZUtils 未在 Application 中初始化")
        }
    }

    /**
     * loading 加载框
     */
    fun showLoading(activity: Activity, msg: String, cancelable: Boolean = true) {
        zLoadingDialog = ZLoadingDialog(activity, msg, cancelable)
        zLoadingDialog?.show()
    }

    /**
     * 取消 加载框
     */
    fun hideLoading() {
        if (null != zLoadingDialog && zLoadingDialog?.isShowing!!) {
            zLoadingDialog?.dismiss()
            zLoadingDialog = null
        }
    }

    /**
     * loading 是否显示，需在showLoading()之后调用，否则未null
     */
    fun loadingIsShowing(): Boolean? = zLoadingDialog?.isShowing

}