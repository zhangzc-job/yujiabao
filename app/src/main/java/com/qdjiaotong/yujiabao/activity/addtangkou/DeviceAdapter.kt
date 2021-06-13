package com.qdjiaotong.yujiabao.activity.addtangkou

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.qdjiaotong.yujiabao.R

class DeviceAdapter(var items:MutableList<DeviceItem>) : BaseQuickAdapter<DeviceItem,BaseViewHolder>(R.layout.list_item_device,items) {
    override fun convert(holder: BaseViewHolder, item: DeviceItem) {

    }
}