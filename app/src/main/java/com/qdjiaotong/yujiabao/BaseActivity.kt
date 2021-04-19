package com.qdjiaotong.yujiabao

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.qdjiaotong.yujiabao.databinding.ActivityWebViewBinding

open class BaseActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("BaseActivity", javaClass.simpleName)
    }

}