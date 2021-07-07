package com.zzc.chaobaselibrary.utils

import android.annotation.SuppressLint
import android.view.Gravity
import android.widget.Toast

/**
 * 任意线程，不重复显示
 */

object ToastUtils {

    private var toast: Toast? = null

    /**
     * 底部显示（默认）
     */

    fun show(msg: String) {
        if ("main" == Thread.currentThread().name) {
            createToast(msg)
        } else {
            ActivityUtil.currentActivity?.runOnUiThread { createToast(msg) }
        }
    }

    @SuppressLint("ShowToast")
    private fun createToast(msg: String) {
        if (toast == null) {
            toast = Toast.makeText(ZUtils.getApp().applicationContext, msg, Toast.LENGTH_SHORT)
        } else {
            toast!!.setText(msg)
        }
        toast!!.show()
    }

    /**
     * 居中显示
     */
    fun showCenter(msg: String) {
        if ("main" == Thread.currentThread().name) {
            createCenterToast(msg)
        } else {
            ActivityUtil.currentActivity!!.runOnUiThread { createCenterToast(msg) }
        }
    }

    private fun createCenterToast(msg: String) {
        if (toast == null) {
            toast = Toast.makeText(ZUtils.getApp().applicationContext, msg, Toast.LENGTH_SHORT)
        } else {
            toast!!.setText(msg)
        }
        toast!!.setGravity(Gravity.CENTER, 0, 0)
        toast!!.show()
    }

    /**
     * 取消toast
     * onDestroy时调用，或者 onPause
     * 当页面finish之后，在下一个页面不会显示
     */
    fun cancel() {
        toast?.cancel()
    }

    /**
     * 回收Toast
     */
    fun release() {
        toast?.let {
            it.cancel()
            toast = null
        }
    }

}