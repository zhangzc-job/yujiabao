package com.qdjiaotong.yujiabao.activity.mytangkou

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.qdjiaotong.yujiabao.R
import com.qdjiaotong.yujiabao.activity.tangkoudetails.ChartsActivity
import com.qdjiaotong.yujiabao.model.TangKouItem


class TangKouAdapter(tangkouItems: MutableList<TangKouItem>) :
    BaseQuickAdapter<TangKouItem, BaseViewHolder>(R.layout.list_item_tangkou, tangkouItems) {

//    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val nameTv: TextView = view.findViewById(R.id.tkNameTv)
//        val numberTv: TextView = view.findViewById(R.id.tkNumberTv)
//        val addressTv: TextView = view.findViewById(R.id.tkAddressTv)
//    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view =
//            LayoutInflater.from(parent.context).inflate(R.layout.list_item_tangkou, parent, false)
//        val viewHolder = ViewHolder(view)
//        viewHolder.itemView.setOnClickListener {
//            val position = viewHolder.adapterPosition
//            val item = tangkouItems[position]
//            val intent = Intent(parent.context, ChartsActivity::class.java)
//            intent.putExtra("id", item.fishpondId)
//            parent.context.startActivity(intent)
//        }
//
//        return viewHolder
//    }

    override fun convert(holder: BaseViewHolder, item: TangKouItem) {
        holder.setText(R.id.tkNameTv, item.yjhFishpond.name)
        holder.setText(R.id.tkNumberTv, "塘口编号：${item.yjhFishpond.code}")
        holder.setText(R.id.tkAddressTv, "日期：${item.yjhFishpond.createDate}")
    }
}