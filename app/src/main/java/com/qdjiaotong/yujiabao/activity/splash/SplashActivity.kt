package com.qdjiaotong.yujiabao.activity.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import com.gyf.immersionbar.ImmersionBar
import com.qdjiaotong.yujiabao.R
import com.qdjiaotong.yujiabao.activity.login.ui.LoginActivity
import com.qdjiaotong.yujiabao.databinding.ActivitySplashBinding
import com.zzc.chaobaselibrary.base.BaseActivity
import com.zzc.chaobaselibrary.utils.setOnclickNoRepeat

class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    lateinit var timer: CountDownTimer

    override fun getViewBinding(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun initialize() {
        super.initialize()
        ImmersionBar.with(this).fitsSystemWindows(true).barColor(R.color.theme_color).init()
        setListener()
        setAnimation()
    }

    private fun setListener() {
        mBinding.tvSkip.setOnclickNoRepeat {
            if (this::timer.isInitialized) timer.cancel()
            jump2Home()
        }
    }

    private fun setAnimation() {
        val animation = AlphaAnimation(0.1f, 1.0f)
        //设置持续时间3s
        animation.duration = 1500
        mBinding.llMain.animation = animation
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
                mBinding.tvSkip.visibility = View.VISIBLE
                startCountDown()
            }

            override fun onAnimationRepeat(p0: Animation?) {
            }

        })
    }

    fun jump2Home() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun startCountDown() {
        timer = object : CountDownTimer(5 * 1000, 1000) {
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                mBinding.tvSkip.text = "跳过${millisUntilFinished / 1000.toInt()}"
            }
            override fun onFinish() {
                jump2Home()
            }
        }
        timer.start()
    }

    private fun checkLogin(){

    }



}