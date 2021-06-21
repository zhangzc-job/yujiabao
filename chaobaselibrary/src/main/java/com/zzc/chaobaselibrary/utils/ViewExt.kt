package com.zzc.chaobaselibrary.utils

import android.view.View

/**
 * 防止重复点击
 * */
var lastClickTime = 0L
fun View.setOnclickNoRepeat(interval: Long = 500, onClick: (View) -> Unit) {

    this.setOnClickListener {
        val currentTime = System.currentTimeMillis()
        if (lastClickTime != 0L && (currentTime - lastClickTime < interval)) {
            return@setOnClickListener
        }
        lastClickTime = currentTime
        onClick.invoke(it)
    }


}