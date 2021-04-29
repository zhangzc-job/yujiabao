package com.qdjiaotong.yujiabao.activity.tangkoudetails

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.qdjiaotong.yujiabao.YuJiaBaoApplication
import com.qdjiaotong.yujiabao.api.RetrofitClient
import com.qdjiaotong.yujiabao.model.ChartsItem
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChartsViewModel : ViewModel() {

    val charts = MutableLiveData<ChartsItem>()

    fun getDetails(fishpondId: String) {
        val map = HashMap<String, String>()
        map["__sid"] = YuJiaBaoApplication.TOKEN
        map["fishpondId"] = fishpondId
//        map["fishpondid"]="1376125636512940032"
        map["type"] = "h6"
        RetrofitClient.instance?.api?.chartsDetails(map)?.enqueue(object :
            Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val ddd = response.body()?.string();
                Log.i("dddddddddcccccddddd", ddd + "")
                val c = Gson().fromJson<ChartsItem>(ddd, ChartsItem::class.java)
                Log.i("dddddddddd", c.toString())
                charts.value = c
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.i("dddddddddcccccddddd", "获取失败了")
            }

        })

    }

}