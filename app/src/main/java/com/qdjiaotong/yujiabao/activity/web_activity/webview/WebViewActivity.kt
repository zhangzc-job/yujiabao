package com.qdjiaotong.yujiabao.activity.web_activity.webview

import android.os.Bundle
import android.webkit.WebViewClient
import com.qdjiaotong.yujiabao.BaseActivity
import com.qdjiaotong.yujiabao.databinding.ActivityWebViewBinding

class WebViewActivity : BaseActivity() {

    lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        binding.webView.settings.javaScriptEnabled = true
        binding.webView.webViewClient = WebViewClient()
//        binding.webView.loadUrl("https://baidu.com")
        binding.webView.loadUrl("http://tags.news.sina.com.cn/渔民")
    }
}