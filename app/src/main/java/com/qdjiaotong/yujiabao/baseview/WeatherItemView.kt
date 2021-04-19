package com.qdjiaotong.yujiabao.baseview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.qdjiaotong.yujiabao.R
import org.w3c.dom.Text

class WeatherItemView(context: Context, attrs:AttributeSet?):LinearLayout(context,attrs) {

    var view: View =LayoutInflater.from(context).inflate(R.layout.view_weather_item,this)
    val title:TextView
    val img:ImageView
    val value:TextView

    init {
        title=view.findViewById(R.id.weather_item_title)
        img=view.findViewById(R.id.weather_item_img)
        value=view.findViewById(R.id.weather_item_value)
    }

}