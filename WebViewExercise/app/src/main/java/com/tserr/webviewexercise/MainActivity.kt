package com.tserr.webviewexercise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.tserr.webviewexercise.databinding.ActivityMainBinding

const val NATIVE_COLOR_RES = "com.tserr.webviewexercise.NATIVE_COLOR_RES"
const val WEB_COLOR_RES = "com.tserr.webviewexercise.WEB_COLOR_RES"

class MainActivity : AppCompatActivity() {

    private val resourceManager = ResourceManager(applicationContext)

    private val viewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory(resourceManager))[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        intent?.run {
            resourceManager.nativeColorResId = getIntExtra(NATIVE_COLOR_RES, R.color.colorNativeButtonClickedRed)
            resourceManager.webColorResId = getIntExtra(WEB_COLOR_RES, R.color.colorWebButtonClickedRed)
        }

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}
