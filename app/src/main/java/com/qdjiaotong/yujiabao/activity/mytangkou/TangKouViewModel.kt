package com.qdjiaotong.yujiabao.activity.mytangkou

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.qdjiaotong.yujiabao.YuJiaBaoApplication
import com.qdjiaotong.yujiabao.api.RetrofitClient
import com.qdjiaotong.yujiabao.model.TangKouItem
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TangKouViewModel : ViewModel() {

    val tankous = MutableLiveData<List<TangKouItem>>()

//    val tangKouList:LiveData<PagedList<TangKouItem>>= TangKou

    fun getListItems() {


        var tangKouList: ArrayList<TangKouItem>

        val map = HashMap<String, String>()
        map["__sid"] = YuJiaBaoApplication.TOKEN
        RetrofitClient.instance?.api?.tangKouList(map)?.enqueue(object :
            Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val ddd = response.body()?.string();
                Log.i("dddddddddcccccddddd", ddd + "")

                val gson = Gson()
                val typeOf = object : TypeToken<List<TangKouItem>>() {}.type

                val list = gson.fromJson<List<TangKouItem>>(ddd, typeOf)

                tankous.value = list

            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.i("dddddddddcccccddddd", "获取失败了")
            }

        })
    }


}