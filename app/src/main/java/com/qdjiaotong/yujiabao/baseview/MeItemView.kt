package com.qdjiaotong.yujiabao.baseview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.qdjiaotong.yujiabao.R

class MeItemView(context: Context, attr: AttributeSet) : LinearLayout(context, attr) {

    var view: View = LayoutInflater.from(context).inflate(R.layout.view_me_item, this)
    var img: ImageView
    var title: TextView

    init {
        img = view.findViewById(R.id.iv_me_item_view)
        title = view.findViewById(R.id.tv_me_item_view)

        val ats=context.obtainStyledAttributes(attr,R.styleable.meItem)
        img.setImageResource(ats.getResourceId(R.styleable.meItem_me_item_image,R.drawable.ic_launcher_background))
        title.text=ats.getString(R.styleable.meItem_me_item_title)

    }

}