package com.tserr.webviewexercise

import android.content.Context

class ResourceManager (private val context: Context) {

    var nativeColorResId = R.color.colorNativeButtonClickedRed

    var webColorResId = R.color.colorWebButtonClickedRed

    val nativeColorInt: Int
        get() = context.getColor(nativeColorResId)

    val webColorInt: Int
        get() = context.getColor(webColorResId)

    val nativeColorString: String
        get() = String.format("#%06X", 0xFFFFFF and nativeColorInt)

    val webColorString: String
        get() = String.format("#%06X", 0xFFFFFF and webColorInt)
}