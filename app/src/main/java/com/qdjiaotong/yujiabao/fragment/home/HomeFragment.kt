package com.qdjiaotong.yujiabao.fragment.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.qdjiaotong.yujiabao.databinding.FragmentHomeBinding
import com.qdjiaotong.yujiabao.activity.mytangkou.MyTangKouActivity
import com.qdjiaotong.yujiabao.activity.web_activity.webview.WebViewActivity
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import com.youth.banner.loader.ImageLoader

class HomeFragment : Fragment(),View.OnClickListener{

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    lateinit var banner: Banner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        banner = binding.homeBanner
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var list_path: ArrayList<String>? = null
        var list_title: ArrayList<String>? = null

        //放图片地址的集合
        list_path = ArrayList<String>()
        //放标题的集合
        list_title = ArrayList<String>()


        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
        list_path.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fphotocdn.sohu.com%2F20130604%2FImg377951400.jpg&refer=http%3A%2F%2Fphotocdn.sohu.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1622698212&t=9bed5d0127beed327927ce262470a831");
        list_path.add("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F014d8759ddb5f3a801204463f95c06.JPG%402o.jpg&refer=http%3A%2F%2Fimg.zcool.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1622698294&t=b423ef3262bd1bfe206362905e6b70c1");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2e7vsaj30ci08cglz.jpg");

        list_title.add("好好学习");
        list_title.add("天天向上");
        list_title.add("热爱劳动");
        list_title.add("不搞对象");
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
        banner.setImageLoader(MyLoader())
        banner.setImages(list_path)
        banner.setBannerTitles(list_title)
        banner.setBannerAnimation(Transformer.Default)
        banner.setDelayTime(3000)
        banner.isAutoPlay(true)
        banner.setIndicatorGravity(BannerConfig.CENTER)
            .start()

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

    inner class MyLoader : ImageLoader() {
        override fun displayImage(context: Context, path: Any?, imageView: ImageView) {
            Glide.with(context).load(path as String).into(imageView)
        }
    }

    override fun onClick(p0: View?) {
        when(p0){
            binding.homeZixun ->startActivity(
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
                    WebViewActivity::class.java
                )
            )
            binding.homeShengchan->startActivity(
                Intent(
                    activity,
                    WebViewActivity::class.java
                )
            )
        }
    }
}