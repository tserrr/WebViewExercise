package com.tserr.webviewexercise

import android.app.Activity
import android.content.Intent

fun showNativeWebViewAcitivty(activity: Activity, nativeColorResId: Int, webColorResId: Int) {
    val intent = Intent(activity, MainActivity::class.java).apply {
        putExtra(NATIVE_COLOR_RES, nativeColorResId)
        putExtra(WEB_COLOR_RES, webColorResId)
    }
    activity.startActivity(intent)
}