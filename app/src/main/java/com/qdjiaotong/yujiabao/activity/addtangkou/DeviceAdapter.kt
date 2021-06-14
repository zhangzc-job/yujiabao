package com.qdjiaotong.yujiabao.activity.addtangkou

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.qdjiaotong.yujiabao.R
import com.qdjiaotong.yujiabao.model.DeviceItem

class DeviceAdapter(var items:MutableList<DeviceItem>) : BaseQuickAdapter<DeviceItem,BaseViewHolder>(R.layout.list_item_device,items) {
    override fun convert(holder: BaseViewHolder, item: DeviceItem) {
        holder.setText(R.id.device_number_tv,item.code)
        holder.setText(R.id.device_name_tv,item.name)
    }
}