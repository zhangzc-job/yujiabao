package com.qdjiaotong.yujiabao

import android.app.Application
import android.content.Context
import android.widget.Toast
import com.tencent.mmkv.MMKV
import com.zzc.chaobaselibrary.kotlinding.showToast

class YuJiaBaoApplication : Application() {

    companion object {
        var TOKEN = "mmmmmmmmmmmmmm"
        lateinit var context: Context

    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext

        val rootDir= MMKV.initialize(this)
        rootDir.showToast(context)
    }


}