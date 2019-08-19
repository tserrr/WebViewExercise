package com.tserr.webviewexercise

import android.content.Context

class ResourceManager (private val context: Context) {

    val nativeColorInt: Int
        get() = context.getColor(R.color.colorNativeButtonClickedRed)

    val webColorInt: Int
        get() = context.getColor(R.color.colorWebButtonClickedRed)

    val nativeColorString: String
        get() = String.format("#%06X", 0xFFFFFF and nativeColorInt)

    val webColorString: String
        get() = String.format("#%06X", 0xFFFFFF and webColorInt)
}