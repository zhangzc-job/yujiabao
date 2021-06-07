package com.qdjiaotong.yujiabao.activity.addtangkou

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.interfaces.OnSelectListener
import com.qdjiaotong.yujiabao.databinding.ActivityAddTangKouBinding
import com.qdjiaotong.yujiabao.model.TangKouItem
import com.zzc.chaobaselibrary.base.ZBaseActivity
import com.zzc.chaobaselibrary.kotlinding.showToast

class addTangKouActivity : ZBaseActivity() {

    lateinit var cBinding: ActivityAddTangKouBinding

    val years = arrayOf("1年", "2年", "3年")

    lateinit var viewModel:AddTangKouViewModel




    override fun initView() {

        cBinding = ActivityAddTangKouBinding.inflate(layoutInflater)

        viewModel=ViewModelProvider(this).get(AddTangKouViewModel::class.java)

        val item =intent.getSerializableExtra("data") as? TangKouItem
        var tt=intent.getStringExtra("tt")
        Log.i("ddddddd",item.toString())
        if (tt != null) {
            Log.i("ddddddd", tt!!)
        }

        if(item!=null){
            initTitleBar(true,"编辑塘口")
        }else {
            initTitleBar(true,"新增塘口")
        }

    }

    override fun getLayoutView(): View {
        return cBinding.root
    }

    override fun initListener() {
        cBinding.addItemBn.setOnClickListener {
//            XPopup.Builder(this).asCenterList("请选择池龄", years,
//                OnSelectListener { position, text -> years[position].showToast(this) }).show()
            viewModel.addTangKou()
        }
    }
}