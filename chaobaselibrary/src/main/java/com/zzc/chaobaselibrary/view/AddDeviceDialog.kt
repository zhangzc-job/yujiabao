package com.zzc.chaobaselibrary.view

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import com.zzc.chaobaselibrary.R

class AddDeviceDialog:Dialog {

    constructor(context:Context):super(context){

    }

    constructor(context: Context,themeResId:Int):super(context,themeResId){

    }

    constructor(context: Context,cancelable:Boolean,cancelListener:DialogInterface.OnCancelListener):super(context,cancelable,cancelListener){

    }

    class Builder(val context: Context){
        var mDialog:AddDeviceDialog?=null
        init {
            mDialog= AddDeviceDialog(context, R.style.custom_dialog)
            val inflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
            val mLayout=inflater.inflate(R.layout.view_add_device,null,false)
            mDialog!!.addContentView(mLayout, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT))
        }

        fun create(): AddDeviceDialog? {
            return mDialog
        }


    }

}