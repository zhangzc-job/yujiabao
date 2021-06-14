package com.qdjiaotong.yujiabao.activity.addtangkou

import android.app.SearchManager
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.qdjiaotong.yujiabao.R
import com.qdjiaotong.yujiabao.YuJiaBaoApplication.Companion.context
import com.qdjiaotong.yujiabao.activity.mytangkou.TangKouAdapter
import com.qdjiaotong.yujiabao.databinding.ActivityAddTangKouBinding
import com.qdjiaotong.yujiabao.model.DeviceItem
import com.qdjiaotong.yujiabao.model.TangKouItem
import com.zzc.chaobaselibrary.base.ZBaseActivity
import com.zzc.chaobaselibrary.kotlinding.showToast
import com.zzc.chaobaselibrary.view.AddDeviceDialog
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.interfaces.OnCancelListener
import com.lxj.xpopup.interfaces.OnConfirmListener


class addTangKouActivity : ZBaseActivity() {

    lateinit var cBinding: ActivityAddTangKouBinding

    val years = arrayOf("1年", "2年", "3年")

    lateinit var viewModel: AddTangKouViewModel

    var isEdit = false

    var item:TangKouItem?=null

    var deviceItems=ArrayList<DeviceItem>()


    override fun initView() {

        cBinding = ActivityAddTangKouBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this).get(AddTangKouViewModel::class.java)

        item= intent.getSerializableExtra("data") as? TangKouItem
        var tt = intent.getStringExtra("tt")
        Log.i("ddddddd", item.toString())
        if (tt != null) {
            Log.i("ddddddd", tt!!)
        }

        if (item != null) {
            initTitleBar(true, "编辑塘口")
            isEdit = true
            cBinding.addItem1.setContent(item!!.yjhFishpond.name)
            cBinding.addItem2.setContent(item!!.yjhFishpond.code)
            cBinding.addItem2.setCanChange(false)
            viewModel.findDevice(item!!.yjhFishpond.id)


        } else {
            initTitleBar(true, "新增塘口")
        }


        val layoutManager=LinearLayoutManager(this)
        cBinding.addTangkouRcv.layoutManager=layoutManager
        val adapter=DeviceAdapter(deviceItems)
        cBinding.addTangkouRcv.adapter=adapter

        adapter.addChildClickViewIds(R.id.device_delete_bn)

        adapter.setOnItemChildClickListener { adapter, view, position ->
            XPopup.Builder(this).asConfirm("提示","确定删除该设备吗？",object : OnConfirmListener{
                override fun onConfirm() {
                    viewModel.deleteDevice(deviceItems[position].id)
                }

            },object : OnCancelListener {
                override fun onCancel() {
                    "cancel".showToast(context)
                }

            }).show()
        }

        viewModel.addTangKouStatus.observe(this, Observer {
            setResult(100,intent)
            finish()
        })

        viewModel.deleteDeviceStatus.observe(this, Observer{
            if(item!=null) {
                item?.yjhFishpond?.id?.let { it1 -> viewModel.findDevice(it1) }
            }
        })

        viewModel.addDeviceStatus.observe(this, Observer{
            if(item!=null) {
                item?.yjhFishpond?.id?.let { it1 -> viewModel.findDevice(it1) }
            }
        })

        viewModel.devices.observe(this, Observer {
            if (it.isEmpty()) {
                "暂无数据".showToast(this)
                deviceItems.clear()
                adapter.notifyDataSetChanged()
            } else {
                showContentView()
                deviceItems.clear()
                deviceItems.addAll(it)
                adapter.notifyDataSetChanged()
            }
        })

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
                if(isEdit){
                    viewModel.updateUserFishpond(item!!.fishpondId,name)
                }else {
                    viewModel.addTangKou(code, name)
                }
            }
        }

        cBinding.mbnAddDevice.setOnClickListener {

            AddDeviceDialog.Builder(this)
                .setClickOKListener(object : AddDeviceDialog.OnAddClickListener {
                    override fun onClick(type: String, code: String) {

                        item?.yjhFishpond?.id?.let { it1 -> viewModel.addDevice(it1,type,code) }


                    }

                }).create()?.show()


            if(item!=null) {
                item?.yjhFishpond?.id?.let { it1 -> viewModel.findDevice(it1) }
            }
        }
    }
}


