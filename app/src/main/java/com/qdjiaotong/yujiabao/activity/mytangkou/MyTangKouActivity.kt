package com.qdjiaotong.yujiabao.activity.mytangkou

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.qdjiaotong.yujiabao.BaseActivity
import com.qdjiaotong.yujiabao.R
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
        }

        adapter.animationEnable = true
        adapter.setAnimationWithDefault(BaseQuickAdapter.AnimationType.SlideInLeft)

        viewModel.tankous.observe(this, Observer<List<TangKouItem>> {

            if (it.isEmpty()) {
                "暂无数据".showToast(this)
                showEmptyView("没有数据")
            } else {
                showContentView()
                tangKouList.addAll(it)
//                adapter.notifyDataSetChanged()
            }
        })


        viewModel.getListItems()
    }


}