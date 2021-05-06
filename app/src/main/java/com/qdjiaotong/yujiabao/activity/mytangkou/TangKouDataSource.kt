package com.qdjiaotong.yujiabao.activity.mytangkou

import androidx.paging.ItemKeyedDataSource
import com.qdjiaotong.yujiabao.model.TangKouItem
import java.util.*
import kotlin.collections.ArrayList

class TangKouDataSource() : ItemKeyedDataSource<Date, TangKouItem>() {



    override fun loadInitial(
        params: LoadInitialParams<Date>,
        callback: LoadInitialCallback<TangKouItem>
    ) {
//        val items=fetchItems(params.requestedInitialKey,params.requestedLoadSize)
//        callback.onResult(items)
    }

    override fun loadAfter(params: LoadParams<Date>, callback: LoadCallback<TangKouItem>) {
//        val items=fetchItems(params.key,params.requestedLoadSize)
//        callback.onResult(items)
    }

    override fun loadBefore(params: LoadParams<Date>, callback: LoadCallback<TangKouItem>) {
    }

    override fun getKey(item: TangKouItem): Date {
        return item.getStartTime()
    }


//    fun fetchItems(key:Date?,size:Int):List<TangKouItem>{
//        var items=ArrayList<TangKouItem>()
//        items.add(TangKouItem())
//        items.add(TangKouItem())
//        items.add(TangKouItem())
//        items.add(TangKouItem())
//        items.add(TangKouItem())
//        return items
//
//    }
}