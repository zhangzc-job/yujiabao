package com.zzc.chaobaselibrary.utils

import okhttp3.Callback
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.HttpURLConnection

object OkHttpUtil {

    val client = OkHttpClient()
    val request = Request.Builder()
        .url("https://www.baidu.com").build()
    val response = client.newCall(request).execute()

//    val responseData= response.body?.string()

    //发送post请求，需要建立 requestBody对象来存储带提交的数据
    val requestBody = FormBody.Builder()
        .add("username", "admin")
        .add("password", "123445")
        .build()


    fun sendOkHttpRequest(address: String, callback: Callback) {

        val client = OkHttpClient()
        val request = Request.Builder()
            .url(address)
            .build()
        client.newCall(request).enqueue(callback)

    }


}