package com.zzc.chaobaselibrary.view

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
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
        private var mDialog: AddDeviceDialog = AddDeviceDialog(context, R.style.dialog_ftp_success)

        val inflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val mLayout = inflater.inflate(R.layout.view_add_device, null) as View

        private var listener: OnAddClickListener? = null

        fun setClickOKListener(listener: OnAddClickListener): Builder {
            this.listener = listener
            return this
        }

        fun create(): AddDeviceDialog? {


            mDialog.setContentView(mLayout)

            var ty = mLayout.findViewById<RadioGroup>(R.id.add_device_type_rg)
            var ddd = mLayout.findViewById<EditText>(R.id.add_device_input_et)
            val cancelBn = mLayout.findViewById<AppCompatButton>(R.id.add_device_cancel_bn)
            val addBn = mLayout.findViewById<AppCompatButton>(R.id.add_device_add_bn)


            var win = mDialog.window
            if (win != null) {
                win.decorView.setPadding(50, 0, 50, 10)
                val lp = win.attributes
                lp.width = WindowManager.LayoutParams.MATCH_PARENT
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT
                win.attributes = lp
            }

//
            addBn.setOnClickListener {
                var type = if (ty.checkedRadioButtonId == R.id.type1) {
                    "temperature"
                } else {
                    "oxygen"
                }
                listener?.onClick(type, ddd.text.toString())
                mDialog.dismiss()
            }
            cancelBn.setOnClickListener {
                mDialog.dismiss()
            }
            return mDialog
        }


    }

    interface OnAddClickListener {
        fun onClick(type: String, code: String)
    }

}