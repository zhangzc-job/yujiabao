package com.qdjiaotong.yujiabao.activity.login.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.qdjiaotong.yujiabao.BaseActivity
import com.qdjiaotong.yujiabao.MainActivity
import com.qdjiaotong.yujiabao.YuJiaBaoApplication
import com.qdjiaotong.yujiabao.api.ApiService
import com.qdjiaotong.yujiabao.api.RetrofitClient
import com.qdjiaotong.yujiabao.databinding.ActivityLoginBinding
import com.qdjiaotong.yujiabao.model.UserData
import com.zzc.chaobaselibrary.kotlinding.showToast
import com.zzc.chaobaselibrary.utils.Base64Utils
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.concurrent.thread

class LoginActivity : BaseActivity() {

    lateinit var viewModel: LoginViewModel

    lateinit var api: ApiService

    lateinit var binding: ActivityLoginBinding
    var username = ""
    var password = ""
    val __ajax = "true"
    //    val username = "lmshykj"
    //    val password = "123456"
    //    val __ajax = __ajaxtrue

    //    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this,
            LoginViewModelFactory(username, password)
        ).get(LoginViewModel::class.java)


        viewModel.userData.observe(this, Observer { userData ->
            if (userData.result) {
                userData.message.showToast(YuJiaBaoApplication.context)
                YuJiaBaoApplication.TOKEN = userData.sessionid
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
//                    getTangkouList(userData.sessionid)
            } else {
                "账号或密码错误".showToast(this@LoginActivity)
            }
        })

        binding.login.setOnClickListener {

            username = binding.username.text.toString()
            password = binding.password.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                "请输入用户名和密码".showToast(this)
            } else {
                val name = Base64Utils.stringToBase64(username)
                val pass = Base64Utils.stringToBase64(password)

                viewModel.getUserInfo(name, pass)

            }
        }

    }

//        api.login(User(true, name, pass)).enqueue(object : Callback<ResponseBody> {
//            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                Log.i("dddddddddd", "失败了")
//            }
//
//            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//                val ddd = response.body();
////                val js=JSONObject(ddd)
//                Log.i("dddddddddcccccddddd", ddd?.string() + "")
//            }
//
//        })
}


//    private fun sendRequestWithOkHttp2() {
//
//        thread {
//            val client = OkHttpClient()
//
//            val requestBody = FormBody.Builder()
//                .add("username", username)
//                .add("password", password)
//                .add("__ajax", "true")
//                .build()
//            val request =
//                Request.Builder().url("http://qhygr.qdqihangyun.com/yjh/a/shishi/login")
//                    .addHeader("Accept", "application/json")
//                    .post(requestBody)
//                    .build()
//
//            val response = client.newCall(request).execute()
//            val responseData = response.body?.string()
//            if (responseData != null) {
//                Log.i("ccccccccccccccccccccc", responseData)
//                var jb = JSONObject(responseData)
//            } else {
//                Log.i("cccccccccccccccccccccccccccdddddddddddd", responseData + "")
//            }
//        }
//    }


//}