package com.qdjiaotong.yujiabao.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {
    private val retrofit: Retrofit
    val api: Api
        get() = retrofit.create(Api::class.java)

    companion object {
        private const val BASE_URL = "http://qhygr.qdqihangyun.com/"
        private var retrofitClient: RetrofitClient? = null

        @get:Synchronized
        val instance: RetrofitClient?
            get() {
                if (retrofitClient == null) {
                    retrofitClient = RetrofitClient()
                }
                return retrofitClient
            }
    }

    init {
        retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

