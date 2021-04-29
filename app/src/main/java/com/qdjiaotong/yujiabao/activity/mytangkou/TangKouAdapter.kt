package com.qdjiaotong.yujiabao.activity.mytangkou

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.qdjiaotong.yujiabao.R
import com.qdjiaotong.yujiabao.activity.tangkoudetails.ChartsActivity
import com.qdjiaotong.yujiabao.model.TangKouItem


class TangKouAdapter(val tangkouItems: List<TangKouItem>) :
    RecyclerView.Adapter<TangKouAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTv: TextView = view.findViewById(R.id.tkNameTv)
        val numberTv: TextView = view.findViewById(R.id.tkNumberTv)
        val addressTv: TextView = view.findViewById(R.id.tkAddressTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_tangkou, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val item = tangkouItems[position]
            val intent = Intent(parent.context, ChartsActivity::class.java)
            intent.putExtra("id", item.fishpondId)
            parent.context.startActivity(intent)
        }

        return viewHolder
    }

    override fun getItemCount(): Int {
        return tangkouItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tangkou = tangkouItems[position]
        holder.nameTv.text = tangkou.yjhFishpond.name
        holder.numberTv.text = "塘口编号：${tangkou.yjhFishpond.code}"
        holder.addressTv.text = "地址：${tangkou.yjhFishpond.createDate}"
    }
}