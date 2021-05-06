package com.zzc.chaobaselibrary.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import com.zzc.chaobaselibrary.R
import com.zzc.chaobaselibrary.databinding.ViewBaseStateLayoutBinding

abstract class ZBaseActivity : AppCompatActivity() {

    lateinit var binding: ViewBaseStateLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ViewBaseStateLayoutBinding.inflate(layoutInflater)

        setContentView(binding.root)

        showContentView()

        initView()

        initBaseView()

        initBaseListener()



    }

    fun initTitleBar(isShow: Boolean, title: String) {
        binding.baseTitleBar.text = title
        if (isShow) {
            binding.baseTitleBar.visibility = View.VISIBLE
        } else {
            binding.baseTitleBar.visibility = View.GONE
        }
    }

    fun showProgressView() {
        showView(R.id.base_view_progress)
    }

    fun showLoadingDialog(){
        binding.loadingDialog.visibility=View.VISIBLE
    }

    fun disLoadingDialog(){
        binding.loadingDialog.visibility=View.GONE
    }

    fun showContentView() {
        showView(R.id.base_view_content)
    }

    fun showEmptyView() {
        showView(R.id.base_view_empty)
    }

    fun showEmptyView(resId: Int) {
        showEmptyView()
        binding.baseEmptyTip.text = getString(resId)
    }

    fun showEmptyView(msg: String) {
        showEmptyView()
        binding.baseEmptyTip.text = msg
    }

    fun showView(viewId: Int) {
        for (i in 1 until binding.baseRootView.childCount) {
            if (binding.baseRootView.getChildAt(i).id == viewId) {
                binding.baseRootView.getChildAt(i).visibility = View.VISIBLE
            } else {
                binding.baseRootView.getChildAt(i).visibility = View.GONE
            }
        }
    }

    fun initBaseView() {

        binding.baseViewContent.addView(getLayoutView())

//        LayoutInflater.from(this).inflate(getLayoutId(), binding.baseViewContent, true)
    }

    fun initBaseListener(){
        binding.baseViewEmpty.setOnClickListener {
            onReload()
        }

        initListener()

    }

    fun onReload() {

    }

    abstract fun initView()

    abstract fun getLayoutView(): View

    abstract fun initListener()




}