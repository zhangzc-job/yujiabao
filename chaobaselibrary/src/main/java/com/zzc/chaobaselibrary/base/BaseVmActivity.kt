package com.zzc.chaobaselibrary.base

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseVmActivity<VB : ViewBinding, VM : BaseViewModel>:BaseActivity<VB>() {

    protected open lateinit var mViewModel:VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}