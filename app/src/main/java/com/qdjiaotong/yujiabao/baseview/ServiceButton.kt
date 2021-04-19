package com.qdjiaotong.yujiabao.baseview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.qdjiaotong.yujiabao.R

class ServiceButton(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    var view: View = LayoutInflater.from(context).inflate(R.layout.view_service_button, this)
    var leftIv: ImageView
    var title: TextView
    var content: TextView

    init {
        leftIv = view.findViewById(R.id.service_left_img)
        title = view.findViewById(R.id.service_title_tv)
        content = view.findViewById(R.id.service_content_tv)

        val ats = context.obtainStyledAttributes(attrs, R.styleable.ServiceButton)

        title.text = ats.getString(R.styleable.ServiceButton_service_title_text)
        content.text = ats.getString(R.styleable.ServiceButton_service_msg_text)
        leftIv.setImageResource(ats.getResourceId(R.styleable.ServiceButton_service_left_img,R.drawable.ic_launcher_background))

    }

    fun setTitle(tit: String) {
        title.text = tit
    }

    fun setOnCListener(listener: OnClickListener) {
        view.setOnClickListener(listener)
    }


}