package com.qdjiaotong.yujiabao.api

import com.google.gson.JsonObject
import com.qdjiaotong.yujiabao.model.User
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import java.util.*

public interface ApiService {

    //  http://qhygr.qdqihangyun.com/yjh/a/login

    @POST("yjh/a/login")
    @Headers("Accept:application/json")
    fun login(@Body data: User): Call<ResponseBody>

    @POST("yjh/a/login")
    fun login3(@Body data: RequestBody): Call<ResponseBody>

    /**登陆接口*/
    @POST("yjh/a/login")
    @FormUrlEncoded
    @Headers("Accept:application/json")
    fun login2(@FieldMap map: Map<String, String>): Call<ResponseBody>

}