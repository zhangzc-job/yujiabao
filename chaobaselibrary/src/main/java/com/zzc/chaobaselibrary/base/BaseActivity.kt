package com.zzc.chaobaselibrary.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.zzc.chaobaselibrary.utils.ToastUtils

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    protected open lateinit var mBinding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = getViewBinding()

        setContentView(mBinding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT  //竖屏

        initialize()
    }


    abstract fun getViewBinding(): VB

    open fun initialize() {}

    override fun onDestroy() {
        super.onDestroy()
        ToastUtils.release()
    }
}