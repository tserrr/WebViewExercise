package com.tserr.webviewexercise

import android.annotation.SuppressLint
import android.renderscript.Script
import android.util.Log
import android.webkit.ValueCallback
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.databinding.Observable
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

@SuppressLint("SetJavaScriptEnabled")
@BindingAdapter("model", "lcowner")
fun WebView.setModel(viewModel: MainViewModel, owner: LifecycleOwner) {
    settings.javaScriptEnabled = true
    loadUrl(viewModel.url)
    addJavascriptInterface(viewModel, "Android")
    viewModel.webButtonColorScriptLive.observe(owner, Observer { script ->
        evaluateJavascript(script, null)
    })
}