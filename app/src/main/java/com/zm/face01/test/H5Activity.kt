package com.zm.face01.test

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zm.face01.databinding.ActivityH5Binding

class H5Activity : AppCompatActivity() {
    private lateinit var binding: ActivityH5Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityH5Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        binding.webview.loadUrl("file:///android_asset/ceshi.html")
    }

    @SuppressLint("SetJavaScriptEnabled", "JavascriptInterface")
    private fun initView() {

        val webSetting = binding.webview.settings
        webSetting.javaScriptEnabled = true
        //JS掉用Android 方法
        binding.webview.addJavascriptInterface(this@H5Activity, "android")
        binding.webview.webViewClient = object : WebViewClient() {
            //这个方法在请求资源时调用，可以用来拦截资源请求并返回自定义的资源。
            override fun shouldInterceptRequest(
                view: WebView?,
                request: WebResourceRequest?
            ): WebResourceResponse? {

                return super.shouldInterceptRequest(view, request)
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                //返回true控制webview显示，返回false掉用系统浏览器或第三方浏览器显示
                val hit = view?.hitTestResult
                if (hit != null) {
                    if (hit.extra.isNullOrEmpty() || hit.type == 0) {
                        //为空或者==0都表示即将加载的URL会发生重定向，需要做拦截处理


                    }
                }
                request?.let {


                    if (request.url.toString().startsWith("http://")) {
                        view?.loadUrl(request.url.toString())
                        return false

                    } else {
                        try {
                            val intent = Intent(Intent.ACTION_VIEW, request.url)
                            if (intent.resolveActivity(this@H5Activity.packageManager) != null) {
                                startActivity(intent)
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()

                        }
                    }
                }

                return super.shouldOverrideUrlLoading(view, request)
            }

        }
        binding.btnTest.setOnClickListener { AndroidCallJs() }

    }

    @JavascriptInterface
    fun jsCallAndroid(test: String) {
        runOnUiThread {
            Toast.makeText(this, "Js掉用安卓成功===$test", Toast.LENGTH_SHORT).show()

        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun AndroidCallJs() {
        binding.webview.loadUrl("javascript:toAndroidCall('ssss')")
    }

}