package com.qdjiaotong.yujiabao.activity.login.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.qdjiaotong.yujiabao.BaseActivity
import com.qdjiaotong.yujiabao.MainActivity
import com.qdjiaotong.yujiabao.YuJiaBaoApplication
import com.qdjiaotong.yujiabao.api.ApiService
import com.qdjiaotong.yujiabao.databinding.ActivityLoginBinding
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
import kotlin.collections.HashMap
import kotlin.concurrent.thread

class LoginActivity : BaseActivity() {

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

        binding.login.setOnClickListener {

            username = binding.username.text.toString()
            password = binding.password.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                "请输入用户名和密码".showToast(this)
            } else {
                val name = Base64Utils.stringToBase64(username)
                val pass = Base64Utils.stringToBase64(password)

                sendddd(name, pass)

            }


//            sendRequestWithOkHttp2()

//            Log.i("dddddddd", "ccccccccccccccc")
//
//            var pass = "123456"
//            var password = getEncoder().encodeToString(pass.toByteArray(StandardCharsets.UTF_8))
//
//            val name = "lmshykj"
//            var username = getEncoder().encodeToString(name.toByteArray(StandardCharsets.UTF_8))
//            Log.d("ddddddddddd", username + ",,,," + password)

        }

    }

    fun sendddd(name: String, pass: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://qhygr.qdqihangyun.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(ApiService::class.java)

        val map = HashMap<String, String>()
        map["username"] = name
        map["password"] = pass
        map["__ajax"] = "true"

        api.login2(map).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val ddd = response.body()?.string();
                Log.i("dddddddddcccccddddd", ddd + "")
                val js = JSONObject(ddd)
                if (js.getString("result").equals("true")) {
                    js.getString("message").showToast(YuJiaBaoApplication.context)
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                }else{
                    "账号或密码错误".showToast(this@LoginActivity)
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                val js=JSONObject(ddd)
                Log.i("dddddddddcccccddddd", "失败了。吧的对的")
            }

        })


//        api.login(User(true, username, password)).enqueue(object : Callback<ResponseBody> {
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

    private fun sendRequestWithOkHttp2() {

        thread {
            val client = OkHttpClient()

            val requestBody = FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .add("__ajax", "true")
                .build()
            val request =
                Request.Builder().url("http://qhygr.qdqihangyun.com/yjh/a/shishi/login")
                    .addHeader("Accept", "application/json")
                    .post(requestBody)
                    .build()

            val response = client.newCall(request).execute()
            val responseData = response.body?.string()
            if (responseData != null) {
                Log.i("ccccccccccccccccccccc", responseData)
                var jb = JSONObject(responseData)
            } else {
                Log.i("cccccccccccccccccccccccccccdddddddddddd", responseData + "")
            }
        }
    }


}