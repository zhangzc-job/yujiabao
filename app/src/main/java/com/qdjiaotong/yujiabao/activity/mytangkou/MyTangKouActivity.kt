package com.qdjiaotong.yujiabao.activity.mytangkou

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.qdjiaotong.yujiabao.BaseActivity
import com.qdjiaotong.yujiabao.R
import com.qdjiaotong.yujiabao.databinding.ActivityMyTangKouBinding
import com.qdjiaotong.yujiabao.model.TangKouItem
import com.zzc.chaobaselibrary.base.ZBaseActivity

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
//        rv=findViewById(R.id.tangKouRv)
        bindingT = ActivityMyTangKouBinding.inflate(layoutInflater)
        showProgressView()
        Handler().postDelayed({
            getData()
        }, 2000)
    }

    fun getData() {
        viewModel = ViewModelProvider(this).get(TangKouViewModel::class.java)

        val layoutManager = LinearLayoutManager(this)
        bindingT.tangKouRv.layoutManager = layoutManager
//        rv.layoutManager=layoutManager
        val adapter = TangKouAdapter(tangKouList)
        bindingT.tangKouRv.adapter = adapter
//        rv.adapter=adapter

        viewModel.tankous.observe(this, Observer<List<TangKouItem>> {
            showContentView()
            tangKouList.addAll(it)
            adapter.notifyDataSetChanged()
        })


        viewModel.getListItems()
    }


}