package com.qdjiaotong.yujiabao.activity.mytangkou

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.qdjiaotong.yujiabao.BaseActivity
import com.qdjiaotong.yujiabao.databinding.ActivityMyTangKouBinding
import com.qdjiaotong.yujiabao.model.TangKouItem

class MyTangKouActivity : BaseActivity() {

    lateinit var binding: ActivityMyTangKouBinding
    lateinit var viewModel: TangKouViewModel

    val tangKouList = ArrayList<TangKouItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMyTangKouBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(TangKouViewModel::class.java)

        val layoutManager = LinearLayoutManager(this)
        binding.tangKouRv.layoutManager = layoutManager
        val adapter = TangKouAdapter(tangKouList)
        binding.tangKouRv.adapter = adapter

        viewModel.tankous.observe(this, Observer<List<TangKouItem>> {
            tangKouList.addAll(it)
            adapter.notifyDataSetChanged()
        })


        viewModel.getListItems()
    }


}