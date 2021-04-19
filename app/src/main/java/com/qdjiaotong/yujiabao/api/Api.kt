package com.qdjiaotong.yujiabao.api

import com.qdjiaotong.yujiabao.model.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

public interface Api {

  //  http://qhygr.qdqihangyun.com/yjh/a/login

    @POST("yjh/a/login")
    fun login(@Body data:User):Call<ResponseBody>

}