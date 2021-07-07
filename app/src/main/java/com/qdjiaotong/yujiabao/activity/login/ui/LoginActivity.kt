package com.qdjiaotong.yujiabao.activity.login.ui

import android.content.Intent
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.qdjiaotong.yujiabao.MainActivity
import com.qdjiaotong.yujiabao.YuJiaBaoApplication
import com.qdjiaotong.yujiabao.api.ApiService
import com.qdjiaotong.yujiabao.databinding.ActivityLoginBinding
import com.tencent.mmkv.MMKV
import com.zzc.chaobaselibrary.base.ZBaseActivity
import com.zzc.chaobaselibrary.kotlinding.showToast
import com.zzc.chaobaselibrary.utils.Base64Utils
import com.zzc.chaobaselibrary.utils.LogUtil

class LoginActivity : ZBaseActivity() {

    private val kv = MMKV.defaultMMKV()

    lateinit var viewModel: LoginViewModel

    lateinit var api: ApiService

    lateinit var cBinding: ActivityLoginBinding
    var username = ""
    var password = ""
    val __ajax = "true"
    //    val username = "lmshykj"
    //    val password = "123456"
    //    val __ajax = __ajaxtrue

    override fun initView() {
        cBinding = ActivityLoginBinding.inflate(layoutInflater)
        setBackIvVisible(false)
        viewModel = ViewModelProvider(
            this,
            LoginViewModelFactory(username, password)
        ).get(LoginViewModel::class.java)


        viewModel.userData.observe(this, Observer { userData ->
            disLoadingDialog()
            if (userData.result.equals("true")) {
                if (kv != null) {
                    kv.encode("username", username)
                    kv.encode("password", password)
                }
                userData.message.showToast(this)
                YuJiaBaoApplication.TOKEN = userData.sessionid
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
//                    getTangkouList(userData.sessionid)
            } else {
                "账号或密码错误".showToast(this@LoginActivity)
            }
        })

        if (kv != null) {
            username = kv.decodeString("username", "").toString()
            password = kv.decodeString("password", "").toString()
            cBinding.username.setText(username)
            cBinding.password.setText(password)
        }
    }

    override fun getLayoutView(): View {
        return cBinding.root
    }

    override fun initListener() {
        cBinding.login.setOnClickListener {

            showLoadingDialog()

            LogUtil.d("ddddddddddddddddddddddddddddddddddddddddd")

            username = cBinding.username.text.toString()
            password = cBinding.password.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                "请输入用户名和密码".showToast(this)
            } else {
                val name = Base64Utils.stringToBase64(username)
                val pass = Base64Utils.stringToBase64(password)
                viewModel.getUserInfo(name, pass)
            }
        }
    }
}