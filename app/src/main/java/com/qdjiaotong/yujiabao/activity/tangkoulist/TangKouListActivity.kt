package com.qdjiaotong.yujiabao.activity.tangkoulist


import android.content.Intent
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.qdjiaotong.yujiabao.activity.mytangkou.TangKouAdapter
import com.qdjiaotong.yujiabao.activity.mytangkou.TangKouViewModel
import com.qdjiaotong.yujiabao.activity.tangkoudetails.ChartsActivity
import com.qdjiaotong.yujiabao.databinding.ActivityMyTangKouBinding
import com.qdjiaotong.yujiabao.databinding.ActivityTangKouListBinding
import com.qdjiaotong.yujiabao.model.TangKouItem
import com.zzc.chaobaselibrary.base.ZBaseActivity
import com.zzc.chaobaselibrary.kotlinding.showToast

class TangKouListActivity : ZBaseActivity() {
    //    lateinit var bindingT: ActivityTangKouListBinding
    lateinit var bindingT: ActivityTangKouListBinding
    lateinit var viewModel: TangKouViewModel

    val tangKouList = ArrayList<TangKouItem>()

    override fun initView() {
        bindingT = ActivityTangKouListBinding.inflate(layoutInflater)
        showProgressView()
        getData()
    }

    override fun getLayoutView(): View {
        return bindingT.root
    }

    override fun initListener() {
    }

    fun getData() {
        viewModel = ViewModelProvider(this).get(TangKouViewModel::class.java)
        val layoutManager = LinearLayoutManager(this)
        bindingT.tangkouListRcv.layoutManager = layoutManager
        val adapter = TangItemAdapter(tangKouList)
        bindingT.tangkouListRcv.adapter = adapter
        adapter.setOnItemClickListener { adapter, view, position ->
            val item = tangKouList[position]
            val intent = Intent(this, ChartsActivity::class.java)
            intent.putExtra("id", item.fishpondId)
            startActivity(intent)
//            startActivityForResult(intent,100)
        }
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
}