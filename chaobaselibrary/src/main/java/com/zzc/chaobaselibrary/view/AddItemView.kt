package com.zzc.chaobaselibrary.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.zzc.chaobaselibrary.R
import com.zzc.chaobaselibrary.databinding.ViewAddItemBinding
import org.w3c.dom.Text
import java.util.jar.Attributes

class AddItemView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

//    var binding: ViewAddItemBinding = ViewAddItemBinding.inflate()

    lateinit var titleTv: TextView
    lateinit var contentEt: EditText

    init {
        var view = LayoutInflater.from(context).inflate(R.layout.view_add_item, this)

        titleTv = view.findViewById(R.id.view_add_item_name)
        contentEt = view.findViewById(R.id.view_add_item_content)

        val array = context.obtainStyledAttributes(attrs, R.styleable.AddItemView)

        val title = array.getString(R.styleable.AddItemView_add_item_title)
        val canEdit = array.getBoolean(R.styleable.AddItemView_add_item_can_edit, false)


        Log.i("ssss", title ?: "ssssss")

        titleTv.text = title

        if (canEdit) {

        } else {

            contentEt.isEnabled = false

            contentEt.setCompoundDrawablesWithIntrinsicBounds(
                null,
                null,
                context.getDrawable(R.mipmap.turn_down),
                null
            )

            contentEt.setOnTouchListener(object : OnTouchListener {
                override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                    val drawable = contentEt.compoundDrawables[2]
                    if (drawable == null) {
                        return false
                    }
                    //如果不是按下事件，不再处理
                    if (event?.getAction() != MotionEvent.ACTION_UP)
                        return false
                    if (event?.getX() > contentEt.getWidth()
                        - contentEt.getPaddingRight()
                        - drawable.getIntrinsicWidth()
                    ) {
                        //隐藏软键
//                    v?.setFocusableInTouchMode(false)
//                    v?.setFocusable(false)
                        Log.i("ssssssss", "sssssss3333")
                        //do something

                    } else {
//                    v?.setFocusableInTouchMode(true)
//                    v?.setFocusable(true)
                        return false
                    }

                    return true
                }

            })
        }

    }
}