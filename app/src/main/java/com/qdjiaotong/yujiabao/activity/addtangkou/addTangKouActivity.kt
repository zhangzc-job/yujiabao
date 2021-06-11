package com.qdjiaotong.yujiabao.activity.addtangkou

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.lxj.xpopup.XPopup
import com.qdjiaotong.yujiabao.R
import com.qdjiaotong.yujiabao.YuJiaBaoApplication.Companion.context
import com.qdjiaotong.yujiabao.databinding.ActivityAddTangKouBinding
import com.qdjiaotong.yujiabao.model.TangKouItem
import com.zzc.chaobaselibrary.base.ZBaseActivity
import com.zzc.chaobaselibrary.kotlinding.showToast


class addTangKouActivity : ZBaseActivity() {

    lateinit var cBinding: ActivityAddTangKouBinding

    val years = arrayOf("1年", "2年", "3年")

    lateinit var viewModel: AddTangKouViewModel


    override fun initView() {

        cBinding = ActivityAddTangKouBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this).get(AddTangKouViewModel::class.java)

        val item = intent.getSerializableExtra("data") as? TangKouItem
        var tt = intent.getStringExtra("tt")
        Log.i("ddddddd", item.toString())
        if (tt != null) {
            Log.i("ddddddd", tt!!)
        }

        if (item != null) {
            initTitleBar(true, "编辑塘口")
        } else {
            initTitleBar(true, "新增塘口")
        }

    }

    override fun getLayoutView(): View {
        return cBinding.root
    }

    override fun initListener() {
        cBinding.addItemBn.setOnClickListener {
//            XPopup.Builder(this).asCenterList("请选择池龄", years,
//                OnSelectListener { position, text -> years[position].showToast(this) }).show()
            val name = cBinding.addItem1.getContent()
            val code = cBinding.addItem2.getContent()
            if (name == null || code == null) {
                "请输入有效内容".showToast(this)
            } else {
                viewModel.addTangKou(code, name)
            }
        }

        cBinding.mbnAddDevice.setOnClickListener {

            "dddddd".showToast(this)
//            XPopup.Builder(this).asConfirm(
//                "添加设备",
//                null,
//                "取消",
//                "添加",
//                { "确定按钮".showToast(context) },
//                { "取消按钮".showToast(context) },
//                false,
//                R.layout.view_add_device
//            ).show()
        }
    }
}


