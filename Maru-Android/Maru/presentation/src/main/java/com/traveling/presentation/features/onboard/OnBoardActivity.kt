package com.traveling.presentation.features.onboard

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import com.traveling.presentation.base.BaseActivity
import com.traveling.presentation.databinding.ActivityOnBoardBinding
import com.traveling.presentation.features.main.MainActivity
import com.traveling.presentation.wiget.MaruApplication
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardActivity : BaseActivity<ActivityOnBoardBinding, OnBoardViewModel>() {
    override val viewModel: OnBoardViewModel by viewModels()
    override fun observerViewModel() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCenter.start(
            application, "8d2fe31d-c735-47de-acdf-5670ae460cc7",
            Analytics::class.java, Crashes::class.java
        )
    }

    override fun onStart() {
        super.onStart()
        checkFirst()
    }

    private fun checkFirst() {
        if (MaruApplication.prefs.isFirst) {
            MaruApplication.prefs.isFirst = false
        } else {
            startMainActivity()
        }
    }

    fun startMainActivity() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finishAffinity()
    }
}