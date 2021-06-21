package com.zzc.chaobaselibrary.view

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.widget.TextView
import com.zzc.chaobaselibrary.R

class ZLoadingDialog constructor(
    context: Context,
    msg: String,
    cancelable: Boolean = true,
    theme: Int = R.style.ZLoadingDialog
) : Dialog(context, theme) {

    init {
        setContentView(R.layout.dialog_z_loading)
        setCancelable(cancelable)
        setCanceledOnTouchOutside(cancelable)
        window?.attributes?.gravity = Gravity.CENTER
        val lp = window?.attributes
        lp?.dimAmount = 0.2f
        window?.attributes = lp
        val tvTitle = findViewById<TextView>(R.id.tv_z_loading)
        tvTitle?.text = msg
    }

}