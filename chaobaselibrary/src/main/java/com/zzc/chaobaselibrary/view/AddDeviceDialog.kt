package com.zzc.chaobaselibrary.view

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.widget.AppCompatButton
import com.zzc.chaobaselibrary.R

class AddDeviceDialog : Dialog {

    constructor(context: Context) : super(context) {

    }

    constructor(context: Context, themeResId: Int) : super(context, themeResId) {

    }

    constructor(
        context: Context,
        cancelable: Boolean,
        cancelListener: DialogInterface.OnCancelListener
    ) : super(context, cancelable, cancelListener) {

    }

    class Builder(val context: Context) {
        private var mDialog: AddDeviceDialog = AddDeviceDialog(context, R.style.custom_dialog)


        private var listener: OnAddClickListener? = null


        fun setClickOKListener(listener: OnAddClickListener): Builder {
            this.listener = listener
            return this
        }

        fun create(): AddDeviceDialog? {

            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val mLayout = inflater.inflate(R.layout.view_add_device, null, false)
            var ty: RadioGroup = mLayout.findViewById(R.id.add_device_type_rg)
            val inputEt: EditText = mLayout.findViewById(R.id.add_device_input_et)
            val cancelBn: AppCompatButton = mLayout.findViewById(R.id.add_device_cancel_bn)
            val addBn: AppCompatButton = mLayout.findViewById(R.id.add_device_add_bn)
            mDialog.addContentView(
                mLayout,
                ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            )

//            addBn.setOnClickListener {
//                listener?.onClick("oxygen", "1234567890")
//            }
//            cancelBn.setOnClickListener {
//                mDialog.dismiss()
//            }
            return mDialog
        }


    }

    interface OnAddClickListener {
        fun onClick(type: String, code: String)
    }

}