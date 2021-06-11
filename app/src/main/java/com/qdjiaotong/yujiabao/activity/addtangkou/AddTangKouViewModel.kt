package com.qdjiaotong.yujiabao.activity.addtangkou

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.qdjiaotong.yujiabao.YuJiaBaoApplication
import com.qdjiaotong.yujiabao.api.RetrofitClient
import com.qdjiaotong.yujiabao.model.UserTo
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddTangKouViewModel():ViewModel() {


    fun addTangKou(code:String,name:String){
            val map = HashMap<String, String>()
            map["code"] = code
            map["name"] = name
            map["__sid"] = YuJiaBaoApplication.TOKEN
//            map["__ajax"] = "true"

            RetrofitClient.instance?.api?.saveUserFishpond(map)?.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    val ddd = response.body()?.string();
                    Log.i("dddddddddcccccddddd", ddd + "")
                    val users = Gson().fromJson<UserTo>(ddd, UserTo::class.java)
//                Log.i("dddddddddcccccddddd", users.toString())
                    val js = JSONObject(ddd)
//                    userData.value = users
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                val js=JSONObject(ddd)
                    Log.i("dddddddddcccccddddd", "失败了。吧的对的")
                }

            })

    }

}