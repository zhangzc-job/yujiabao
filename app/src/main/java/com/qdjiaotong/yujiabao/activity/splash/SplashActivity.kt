package com.qdjiaotong.yujiabao.activity.splash

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import com.qdjiaotong.yujiabao.R
import com.qdjiaotong.yujiabao.activity.login.ui.LoginActivity
import com.qdjiaotong.yujiabao.databinding.ActivitySplashBinding
import com.zzc.chaobaselibrary.base.ZBaseActivity

class SplashActivity : ZBaseActivity() {

    lateinit var zBinding: ActivitySplashBinding

    override fun initView() {

        zBinding = ActivitySplashBinding.inflate(layoutInflater)
        initTitleBar(false,"")

    }

    override fun getLayoutView(): View {
        return zBinding.root
    }

    fun setAnimation() {
        val animation = AlphaAnimation(0.1f, 1.0f)
        //设置持续时间3s
        animation.duration = 1500
//        zBinding.splashIv.animation = animation

        zBinding.llMain.animation=animation
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {
                Log.i("ddddddddd","starttttttt")
            }

            override fun onAnimationEnd(p0: Animation?) {
//                val intent=Intent(getIntent(),SplashActivity::class.java)
//                startActivity(intent)
                Log.i("dddddddddd","eeeeeeeeeeeee")
                jump2Home()
            }

            override fun onAnimationRepeat(p0: Animation?) {

            }

        })

    }

    fun jump2Home(){
        val intent=Intent(this,LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun initListener() {

        setAnimation()

    }
}