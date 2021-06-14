package com.qdjiaotong.yujiabao.activity.mytangkou

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.interfaces.OnCancelListener
import com.lxj.xpopup.interfaces.OnConfirmListener
import com.qdjiaotong.yujiabao.R
import com.qdjiaotong.yujiabao.activity.addtangkou.AddTangKouViewModel
import com.qdjiaotong.yujiabao.activity.addtangkou.addTangKouActivity
import com.qdjiaotong.yujiabao.activity.tangkoudetails.ChartsActivity
import com.qdjiaotong.yujiabao.databinding.ActivityMyTangKouBinding
import com.qdjiaotong.yujiabao.model.TangKouItem
import com.zzc.chaobaselibrary.base.ZBaseActivity
import com.zzc.chaobaselibrary.kotlinding.showToast

class MyTangKouActivity : ZBaseActivity() {

    lateinit var bindingT: ActivityMyTangKouBinding
    lateinit var viewModel: TangKouViewModel

    val tangKouList = ArrayList<TangKouItem>()

    override fun getLayoutView(): View {
        return bindingT.root
    }

    override fun initListener() {

        bindingT.addTangKou.setOnClickListener {
            startActivityForResult(Intent(this, addTangKouActivity::class.java),100)
        }


    }

    override fun initView() {
        bindingT = ActivityMyTangKouBinding.inflate(layoutInflater)
        showProgressView()
        getData()
    }

    fun getData() {
        viewModel = ViewModelProvider(this).get(TangKouViewModel::class.java)

        val layoutManager = LinearLayoutManager(this)
        bindingT.tangKouRv.layoutManager = layoutManager
        val adapter = TangKouAdapter(tangKouList)
        bindingT.tangKouRv.adapter = adapter

        adapter.setOnItemClickListener { adapter, view, position ->



            val item = tangKouList[position]
            val intent = Intent(this, ChartsActivity::class.java)
            intent.putExtra("id", item.fishpondId)
            startActivity(intent)
//            startActivityForResult(intent,100)
        }
        adapter.addChildClickViewIds(R.id.tkEditBn)
        adapter.addChildClickViewIds(R.id.tkDeleteBn)
        adapter.setOnItemChildClickListener { adapter, view, position ->

            when(view.id){
                R.id.tkEditBn -> {
                    val item = tangKouList[position]
                    val intent = Intent(this, addTangKouActivity::class.java)
                    intent.putExtra("tt", "mmmmmmm")
                    intent.putExtra("data",tangKouList[position])
                    startActivityForResult(intent,100)
                }
                R.id.tkDeleteBn -> {
                    XPopup.Builder(this).asConfirm("提示","确定删除吗？",object : OnConfirmListener{
                        override fun onConfirm() {
                            viewModel.deleteItem(tangKouList[position].yjhFishpond.id)
                        }

                    },object : OnCancelListener{
                        override fun onCancel() {
                            "cancel".showToast(this@MyTangKouActivity)
                        }

                    }).show()
                }
            }

        }

        adapter.animationEnable = true
        adapter.isAnimationFirstOnly = false
        adapter.setAnimationWithDefault(BaseQuickAdapter.AnimationType.SlideInLeft)

        viewModel.tankous.observe(this, Observer<List<TangKouItem>> {

            if (it.isEmpty()) {
                "暂无数据".showToast(this)
                showEmptyView("没有数据")
            } else {
                showContentView()
                tangKouList.clear()
                tangKouList.addAll(it)
                adapter.notifyDataSetChanged()
            }
        })


        viewModel.getListItems()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.i("ddddddddddddddddddd","结果")
        if(requestCode==100){
            viewModel.getListItems()
        }
    }



}