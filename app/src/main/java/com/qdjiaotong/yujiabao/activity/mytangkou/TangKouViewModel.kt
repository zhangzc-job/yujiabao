package com.qdjiaotong.yujiabao.activity.mytangkou

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

    fun getListItems(){

            val map = HashMap<String, String>()
            map["__sid"] = YuJiaBaoApplication.TOKEN
            RetrofitClient.instance?.api?.tangKouList(map)?.enqueue(object :
                Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    val ddd = response.body()?.string();
                    Log.i("dddddddddcccccddddd", ddd + "")
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.i("dddddddddcccccddddd", "获取失败了")
                }

            })


        val tangKouList=ArrayList<TangKouItem>()
        repeat(2) {

            tangKouList.add(TangKouItem("2012", "9999999ii8u99999", "北京大城市天安门广场"))
            tangKouList.add(TangKouItem("2012", "dddddddd99", "北京大城市"))
            tangKouList.add(TangKouItem("2012", "999966666666999999", "北京大城市"))
            tangKouList.add(TangKouItem("2012", "333333333339999999", "北京大城市"))
            tangKouList.add(TangKouItem("2012", "2222222222999999", "北京大城市"))
        }

        tankous.value=tangKouList
    }


}