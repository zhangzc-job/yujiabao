package com.qdjiaotong.yujiabao.activity.addtangkou

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.interfaces.OnSelectListener
import com.qdjiaotong.yujiabao.BaseActivity
import com.qdjiaotong.yujiabao.R
import com.qdjiaotong.yujiabao.databinding.ActivityAddTangKouBinding
import com.zzc.chaobaselibrary.base.ZBaseActivity
import com.zzc.chaobaselibrary.kotlinding.showToast

class addTangKouActivity : ZBaseActivity() {

    lateinit var cBinding: ActivityAddTangKouBinding

    val years = arrayOf("1年", "2年", "3年")


    override fun initView() {
        cBinding = ActivityAddTangKouBinding.inflate(layoutInflater)

    }

    override fun getLayoutView(): View {
        return cBinding.root
    }

    override fun initListener() {
        cBinding.addItemBn.setOnClickListener {
            XPopup.Builder(this).asCenterList("请选择池龄", years,
                OnSelectListener { position, text -> years[position].showToast(this) }).show()
        }
    }
}