package com.qdjiaotong.yujiabao

import android.app.Application
import com.tencent.mmkv.MMKV
import com.zzc.chaobaselibrary.kotlinding.showToast
import com.zzc.chaobaselibrary.utils.LogUtil
import com.zzc.chaobaselibrary.utils.ZUtils

class YuJiaBaoApplication : Application() {

    companion object {
        var TOKEN = "mmmmmmmmmmmmmm"

        //控制三方库的编译模式
        private const val isDebugMode = true

    }

    override fun onCreate() {
        super.onCreate()
        initZUtils()

        val rootDir = MMKV.initialize(this)
        rootDir.showToast(this)
    }

    private fun initZUtils() {
        ZUtils.init(this)
        LogUtil.setIsLog(isDebugMode)
    }

}