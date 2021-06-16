package com.qdjiaotong.yujiabao.fragment.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.qdjiaotong.yujiabao.activity.mytangkou.MyTangKouActivity
import com.qdjiaotong.yujiabao.activity.tangkoulist.TangKouListActivity
import com.qdjiaotong.yujiabao.activity.web_activity.webview.WebViewActivity
import com.qdjiaotong.yujiabao.databinding.FragmentHomeBinding
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.transformer.AlphaPageTransformer

class HomeFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var list_path: ArrayList<String>? = null
        var list_title: ArrayList<String>? = null

        //放图片地址的集合
        list_path = ArrayList()
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
        list_path.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fphotocdn.sohu.com%2F20130604%2FImg377951400.jpg&refer=http%3A%2F%2Fphotocdn.sohu.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1622698212&t=9bed5d0127beed327927ce262470a831");
        list_path.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F014d8759ddb5f3a801204463f95c06.JPG%402o.jpg&refer=http%3A%2F%2Fimg.zcool.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1622698294&t=b423ef3262bd1bfe206362905e6b70c1");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2e7vsaj30ci08cglz.jpg");

        var adapter = BannerImageAdapter(list_path)

        binding.homeBanner.let {
            it.addBannerLifecycleObserver(this)
            it.indicator = CircleIndicator(context)
            it.setBannerRound(20f)
            it.setPageTransformer(AlphaPageTransformer())
            it.adapter = adapter
        }
        initListener()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initListener() {
        binding.homeZixun.setOnClickListener(this)
        binding.homeGuanli.setOnClickListener(this)
        binding.homeJiance.setOnClickListener(this)
        binding.homeShengchan.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.homeZixun -> startActivity(
                Intent(
                    activity,
                    WebViewActivity::class.java
                )
            )
            binding.homeGuanli -> startActivity(
                Intent(
                    activity,
                    MyTangKouActivity::class.java
                )
            )
            binding.homeJiance -> startActivity(
                Intent(
                    activity,
                    TangKouListActivity::class.java
                )
            )
            binding.homeShengchan -> startActivity(
                Intent(
                    activity,
                    WebViewActivity::class.java
                )
            )
        }
    }
}