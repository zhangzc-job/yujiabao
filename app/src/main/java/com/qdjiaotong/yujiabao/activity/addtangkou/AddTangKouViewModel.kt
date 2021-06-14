package com.qdjiaotong.yujiabao.activity.addtangkou

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.qdjiaotong.yujiabao.YuJiaBaoApplication
import com.qdjiaotong.yujiabao.YuJiaBaoApplication.Companion.context
import com.qdjiaotong.yujiabao.api.RetrofitClient
import com.qdjiaotong.yujiabao.model.DeviceItem
import com.qdjiaotong.yujiabao.model.TangKouItem
import com.qdjiaotong.yujiabao.model.UserTo
import com.zzc.chaobaselibrary.kotlinding.showToast
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddTangKouViewModel() : ViewModel() {

    val devices = MutableLiveData<List<DeviceItem>>()

    val addDeviceStatus = MutableLiveData<Boolean>()

    val findDeviceStatus = MutableLiveData<Boolean>()

    val deleteDeviceStatus = MutableLiveData<Boolean>()

    val addTangKouStatus= MutableLiveData<Boolean>()

    fun addDevice(fishId: String, type: String, code: String) {
        val map = HashMap<String, String>()
        map["fishpondId"] = fishId
        map["deviceTypeCode"] = type
        map["code"] = code
        map["__sid"] = YuJiaBaoApplication.TOKEN
        RetrofitClient.instance?.api?.saveDeviceInfo(map)?.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val ddd = response.body()?.string();
                Log.i("dddddddddcccccddddd", ddd + "")
                val jb = JSONObject(ddd)
                if (code == jb.getString("code")) {
                    "添加成功".showToast(context)
                    addDeviceStatus.postValue(true)
                }

            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.i("dddddddddcccccddddd", "失败了")
            }

        })

    }

    fun deleteDevice(id: String) {
        val map = HashMap<String, String>()
        map["id"] = id
        map["__sid"] = YuJiaBaoApplication.TOKEN
        RetrofitClient.instance?.api?.deleteDeviceInfo(map)
            ?.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    val ddd = response.body()?.string();
                    Log.i("dddddddddcccccddddd", ddd + "")
                    deleteDeviceStatus.postValue(true)
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.i("dddddddddcccccddddd", "失败了")
                }

            })

    }

    fun findDevice(fishId: String) {
        val map = HashMap<String, String>()
        map["fishpondId"] = fishId
        map["__sid"] = YuJiaBaoApplication.TOKEN
        RetrofitClient.instance?.api?.findDeviceList(map)?.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val ddd = response.body()?.string();
                Log.i("dddddddddcccccddddd", ddd + "")
                val gson = Gson()
                val typeOf = object : TypeToken<List<DeviceItem>>() {}.type

                var list = gson.fromJson<List<DeviceItem>>(ddd, typeOf)
                devices.postValue(list)
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.i("dddddddddcccccddddd", "失败了")
            }

        })
    }

    fun updateUserFishpond(id: String, name: String){
        val map = HashMap<String, String>()
        map["id"] = id
        map["name"] = name
        map["__sid"] = YuJiaBaoApplication.TOKEN
//            map["__ajax"] = "true"

        RetrofitClient.instance?.api?.updateUserFishpond(map)
            ?.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    val ddd = response.body()?.string();
                    Log.i("dddddddddcccccddddd", ddd + "")
                    val users = Gson().fromJson<UserTo>(ddd, UserTo::class.java)
//                Log.i("dddddddddcccccddddd", users.toString())
                    val js = JSONObject(ddd)
//                    userData.value = users
                    addTangKouStatus.postValue(true)
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                val js=JSONObject(ddd)
                    Log.i("dddddddddcccccddddd", "失败了。吧的对的")
                }

            })
    }


    fun addTangKou(code: String, name: String) {
        val map = HashMap<String, String>()
        map["code"] = code
        map["name"] = name
        map["__sid"] = YuJiaBaoApplication.TOKEN
//            map["__ajax"] = "true"

        RetrofitClient.instance?.api?.saveUserFishpond(map)
            ?.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    val ddd = response.body()?.string();
                    Log.i("dddddddddcccccddddd", ddd + "")
                    val users = Gson().fromJson<UserTo>(ddd, UserTo::class.java)
//                Log.i("dddddddddcccccddddd", users.toString())
                    val js = JSONObject(ddd)
//                    userData.value = users
                    addTangKouStatus.postValue(true)
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                val js=JSONObject(ddd)
                    Log.i("dddddddddcccccddddd", "失败了。吧的对的")
                }

            })

    }

}