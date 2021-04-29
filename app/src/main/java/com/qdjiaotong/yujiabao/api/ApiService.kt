package com.qdjiaotong.yujiabao.api

import com.qdjiaotong.yujiabao.model.UserTo
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import java.util.*

public interface ApiService {

    /*  http://qhygr.qdqihangyun.com/yjh/swagger-ui.html#/

      http://qhygr.qdqihangyun.com/yjh/a/shishi/listData 塘口列表
      http://qhygr.qdqihangyun.com/yjh/a/shishi/query 塘口数据
      http://qhygr.qdqihangyun.com/yjh/a/shishi/findList 塘口列表（不分页）
     */
    //  http://qhygr.qdqihangyun.com/yjh/a/login

    @POST("yjh/a/login")
    @Headers("Accept:application/json")
    fun login(@Body data: UserTo): Call<ResponseBody>
//
//    @POST("yjh/a/login")
//    fun login3(@Body data: RequestBody): Call<ResponseBody>

    /**例子：占位符*/
    @GET("{page}/get_data.json")
    fun getData1(@Path("page") page: Int): Call<UserTo>

    /**例子：一系列参数*/
    @GET("get_data.json")
    fun getData2(@Query("u") user: String, @Query("t") token: String): Call<UserTo>

    /** 例子：POST请求*/
    @POST("data/create")
    fun createData(@Body data: UserTo): Call<ResponseBody>


    /**登陆接口*/
    @POST("yjh/a/login")
    @FormUrlEncoded
    @Headers("Accept:application/json")
    fun login2(@FieldMap map: Map<String, String>): Call<ResponseBody>

    /**塘口列表 不分页*/
    @POST("yjh/a/shishi/findList")
    @FormUrlEncoded
    @Headers("Accept:application/json")
    fun tangKouList(@FieldMap map: Map<String, String>): Call<ResponseBody>

    /** 堂口数据  对应线性图*/
    @POST("yjh/a/shishi/query")
    @Headers("Accept:application/json")
    @FormUrlEncoded
    fun chartsDetails(@FieldMap map: Map<String, String>):Call<ResponseBody>


}