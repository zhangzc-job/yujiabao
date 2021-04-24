package com.qdjiaotong.yujiabao.activity.mytangkou

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.qdjiaotong.yujiabao.model.TangKouItem
import java.util.*

class TangKouDataSourceFactory : DataSource.Factory<Date, TangKouItem>() {

    val sourceLiveData=MutableLiveData<TangKouDataSource>()
//    var latestSource:TangKouDataSource?

    override fun create(): DataSource<Date, TangKouItem> {
        TODO("Not yet implemented")
    }
}