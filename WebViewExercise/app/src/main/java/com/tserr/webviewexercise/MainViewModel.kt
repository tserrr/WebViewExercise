package com.tserr.webviewexercise

import android.webkit.JavascriptInterface
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

const val ASSET_URL = "file:///android_asset/web_button.html"

class MainViewModel(private val resource: ResourceManager) : ViewModel() {

    val url = ASSET_URL

    val nativeButtonColor = ObservableInt()

    val webButtonColorScriptLive: LiveData<String>
        get() = _webButtonColorLive

    private val _webButtonColorLive = MutableLiveData<String>()

    fun onNativeButtonClicked() {
        nativeButtonColor.set(resource.nativeColorInt)
        _webButtonColorLive.value = "updateWebButtonColor('${resource.nativeColorString}');"
    }

    @JavascriptInterface
    fun onWebButtonClicked() {
        _webButtonColorLive.postValue("updateWebButtonColor('${resource.webColorString}');")
        nativeButtonColor.set(resource.webColorInt)
    }
}