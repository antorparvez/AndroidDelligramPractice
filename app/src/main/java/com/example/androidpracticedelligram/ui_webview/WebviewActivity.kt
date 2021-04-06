package com.example.androidpracticedelligram.ui_webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.androidpracticedelligram.BaseActivity
import com.example.androidpracticedelligram.databinding.ActivityWebviewBinding

class WebviewActivity : BaseActivity() {

    private lateinit var binding: ActivityWebviewBinding
    private val BASE_URL : String ="https://www.antorparvez.me/"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initToolbar("Webview")

        loadWebView()

    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun loadWebView() {
        binding.webview.settings.javaScriptEnabled = true

        binding.webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }
        }
        BASE_URL?.let {
            binding.webview.loadUrl(it)
        }
    }

}