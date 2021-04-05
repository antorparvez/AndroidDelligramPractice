package com.example.androidpracticedelligram.activity_03_webview

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.androidpracticedelligram.BaseActivity
import com.example.androidpracticedelligram.databinding.Activity03Binding

class Activity_webview : BaseActivity() {

    private lateinit var binding: Activity03Binding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity03Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initToolbar("Webview")

        binding.webview.loadUrl("http://www.antorparvez.com")
        binding.webview.settings.javaScriptEnabled = true

        binding.webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }
        }
        binding.webview.loadUrl("https://www.antorparvez.me/")




    }
}