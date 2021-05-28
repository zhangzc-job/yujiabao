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

    lateinit var rootViews: List<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ViewBaseStateLayoutBinding.inflate(layoutInflater)

        rootViews =
            arrayListOf(binding.baseViewContent, binding.baseViewEmpty, binding.baseViewProgress)

        setContentView(binding.root)

        initView()

        binding.baseViewContent.addView(getLayoutView())

        initBaseListener()

        showContentView()


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

    fun showLoadingDialog() {
        binding.loadingDialog.visibility = View.VISIBLE
    }

    fun disLoadingDialog() {
        binding.loadingDialog.visibility = View.GONE
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
//        for (i in 1 until binding.baseRootView.childCount) {
        for (i in rootViews.indices) {
            if (rootViews[i].id == viewId) {
                rootViews[i].visibility = View.VISIBLE
            } else {
                rootViews[i].visibility = View.GONE
            }
        }
    }

    fun initBaseListener() {
        binding.baseViewEmpty.setOnClickListener {
            onReload()
        }

        binding.baseBackIv.setOnClickListener {
            finish()
        }

        initListener()

    }

    fun onReload() {

    }

    fun setBackIvVisible(boolean: Boolean = true) {
        if (boolean) {
            binding.baseBackIv.visibility = View.VISIBLE
        } else {
            binding.baseBackIv.visibility = View.GONE
        }
    }

    abstract fun initView()

    abstract fun getLayoutView(): View

    abstract fun initListener()


}