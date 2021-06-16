package com.qdjiaotong.yujiabao.activity.tangkoulist

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.qdjiaotong.yujiabao.R
import com.qdjiaotong.yujiabao.model.TangKouItem

class TangItemAdapter(tangkouItems: MutableList<TangKouItem>) :
    BaseQuickAdapter<TangKouItem, BaseViewHolder>(R.layout.list_item_tang_item, tangkouItems) {

    override fun convert(holder: BaseViewHolder, item: TangKouItem) {
        holder.setText(R.id.tang_item_code, item.yjhFishpond.code)
        holder.setText(R.id.tang_item_name, item.yjhFishpond.name)
        holder.setText(R.id.tang_item_temperature, item.yjhFishpond.temperatureVal.toString())
        holder.setText(R.id.tang_item_oxygen, item.yjhFishpond.oxygenVal.toString())

    }


}