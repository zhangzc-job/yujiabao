package com.zzc.chaobaselibrary.utils

import android.annotation.SuppressLint
import android.widget.Toast

/**
 * 任意线程，不重复显示
 */

object ToastUtils {

    private var toast: Toast?=null

    /**
     * 底部显示（默认）
     */

    fun show(msg:String){
        if("main"==Thread.currentThread().name){
            createToast(msg)
        }else{

        }
    }

    @SuppressLint("ShowToast")
    private fun createToast(msg:String){
        if(toast==null){
            toast=Toast.makeText(ZUtils.getApp().applicationContext,msg,Toast.LENGTH_SHORT)
        }else{
            toast!!.setText(msg)
        }
        toast!!.show()
    }

}