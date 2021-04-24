package com.qdjiaotong.yujiabao.activity.login.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.qdjiaotong.yujiabao.YuJiaBaoApplication
import com.qdjiaotong.yujiabao.api.RetrofitClient
import com.qdjiaotong.yujiabao.model.UserData
import com.zzc.chaobaselibrary.kotlinding.showToast
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(name: String, pass: String) : ViewModel() {

    val userData = MutableLiveData<UserData>()

    fun getUserInfo(name: String, pass: String) {
        val map = HashMap<String, String>()
        map["username"] = name
        map["password"] = pass
        map["__ajax"] = "true"

        RetrofitClient.instance?.api?.login2(map)?.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val ddd = response.body()?.string();
//                Log.i("dddddddddcccccddddd", ddd + "")
                val users = Gson().fromJson<UserData>(ddd, UserData::class.java)
                Log.i("dddddddddcccccddddd", users.toString())
                val js = JSONObject(ddd)
                userData.value = users
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                val js=JSONObject(ddd)
                Log.i("dddddddddcccccddddd", "失败了。吧的对的")
            }

        })

    }

}