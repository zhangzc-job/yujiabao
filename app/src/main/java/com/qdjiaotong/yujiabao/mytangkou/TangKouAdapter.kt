package com.qdjiaotong.yujiabao.mytangkou

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.qdjiaotong.yujiabao.R
import org.w3c.dom.Text


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
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tangkouItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tangkou = tangkouItems[position]
        holder.nameTv.text = tangkou.name
        holder.numberTv.text = tangkou.number
        holder.addressTv.text = tangkou.address
    }
}