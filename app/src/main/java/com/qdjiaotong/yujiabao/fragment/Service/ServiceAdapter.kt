package com.qdjiaotong.yujiabao.fragment.Service

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.qdjiaotong.yujiabao.R

class ServiceAdapter():BaseQuickAdapter<String, BaseViewHolder>(R.layout.list_item_service) {
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.list_item_service_title,item)
    }
}