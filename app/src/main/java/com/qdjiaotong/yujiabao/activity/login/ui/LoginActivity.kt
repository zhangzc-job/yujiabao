package com.qdjiaotong.yujiabao.activity.login.ui

import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.qdjiaotong.yujiabao.BaseActivity
import com.qdjiaotong.yujiabao.api.Api
import com.qdjiaotong.yujiabao.databinding.ActivityLoginBinding
import com.qdjiaotong.yujiabao.model.User
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import okhttp3.internal.userAgent
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Url
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStream
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import java.util.*
import kotlin.concurrent.thread

class LoginActivity : BaseActivity() {

    lateinit var binding: ActivityLoginBinding
    val username = "bG1zaHlrag=="
//    val username = "lmshykj"
//    val password = "123456"
    val password = "MTIzNDU2"
    val __ajax = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            sendRequestWithOkHttp()
//            sendddd()
//            loginnnnd()
        }

    }

    fun sendddd(){
        val retrofit=Retrofit.Builder()
            .baseUrl("http://qhygr.qdqihangyun.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api=retrofit.create(Api::class.java)
        api.login(User(true,username,password)).enqueue(object : Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.i("dddddddddd","失败了")
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val ddd=response.body();
//                val js=JSONObject(ddd)
                Log.i("dddddddddcccccddddd",ddd?.string()+"")
            }

        })
    }



    private fun sendRequestWithOkHttp() {


//        val base64 = Base64.encodeToString(res.toByteArray(),Base64.DEFAULT)

//        val encoder=Base64.getEncoder().encode()

//        val bytes = res.toByteArray()
//
//        val bytes22 = pass.toByteArray()
//        Base64.getEncoder()

        thread {
            val client = OkHttpClient()

            val requestBody = FormBody.Builder()
//                .add("username", username)
//                .add("password", password)
                .add("pageNo", "1")
                .add("pageSize", "20")
//                .add("__ajax__ajax", "true")
                .add("__sid", "dddddddddddd")
                .build()
//            Log.i("dddddddddddd","ddd"+f)
            val request = Request.Builder().url("http://qhygr.qdqihangyun.com/yjh/a/shishi/listData")
//            val request = Request.Builder().url("http://www.baidu.com")
//                .post(requestBody)
                .build()

            val response = client.newCall(request).execute()
            val responseData = response.body?.string()
            if (responseData != null) {
                Log.i("ccccccccccccccccccccc", responseData)
            } else {
                Log.i("cccccccccccccccccccccccccccdddddddddddd", responseData + "")
            }
        }
    }

    fun loginnnnd(){

        thread {
            try {
                val response=StringBuilder()
                val url=URL("http://qhygr.qdqihangyun.com/yjh/a/shishi/listData")
                val connection=url.openConnection() as HttpURLConnection

                connection.requestMethod="POST"
                connection.connectTimeout=8000
                connection.doOutput=true
                connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded")
                val out=connection.outputStream;
//                out.write(("username=$username&pwd=$password&__ajax=true").toByteArray())
                out.write(("username=$username&pwd=$password&__ajax=true").toByteArray())
                if(connection.responseCode ==HttpURLConnection.HTTP_OK){
                    val input=connection.inputStream
                    val reader=BufferedReader(InputStreamReader(input))
                    reader.use {
                        reader.forEachLine {
                            response.append(it)
                        }
                    }

                    Log.i("mmmmmmmmmmmmmmm",response.toString())
                }
            }catch (e:Exception){

            }

        }

    }

}