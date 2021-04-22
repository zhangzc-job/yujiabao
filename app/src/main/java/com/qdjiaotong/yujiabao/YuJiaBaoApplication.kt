package com.qdjiaotong.yujiabao

import android.app.Application
import android.content.Context

class YuJiaBaoApplication : Application() {

    companion object {
        const val TOKEN = "mmmmmmmmmmmmmm"
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}