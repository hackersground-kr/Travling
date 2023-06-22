package com.traveling.presentation.features.onboard

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import com.traveling.presentation.base.BaseActivity
import com.traveling.presentation.databinding.ActivityOnBoardBinding
import com.traveling.presentation.features.main.MainActivity
import com.traveling.presentation.wiget.MaruApplication
import com.traveling.presentation.wiget.MyService
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardActivity : BaseActivity<ActivityOnBoardBinding, OnBoardViewModel>() {
    override val viewModel: OnBoardViewModel by viewModels()
    override fun observerViewModel() {
    }
    private var OVERLAY_PERMISSION_REQUEST_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCenter.start(
            application, "8d2fe31d-c735-47de-acdf-5670ae460cc7",
            Analytics::class.java, Crashes::class.java
        )
    }

    override fun onStart() {
        super.onStart()
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACTIVITY_RECOGNITION) == PackageManager.PERMISSION_DENIED) {
            requestPermissions(arrayOf(Manifest.permission.ACTIVITY_RECOGNITION), 0)
        }
        checkPermission()
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
    fun checkPermission() {

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(!Settings.canDrawOverlays(this)) {
                val uri = Uri.fromParts("package", packageName, null)
                val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, uri)
                startActivityForResult(intent, OVERLAY_PERMISSION_REQUEST_CODE)
                Log.d("흠2", "checkPermission: ")

//                checkPermission()

            } else {
                val intent = Intent(applicationContext, MyService::class.java)
                startService(intent)
                Log.d("흠1", "checkPermission: ")
            }
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == OVERLAY_PERMISSION_REQUEST_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (Settings.canDrawOverlays(this)) {
                    // 권한 동의가 성공적으로 이루어졌을 때의 처리를 여기에 작성합니다.
                    // 예: 서비스 시작, 추가 작업 등
                    val intent = Intent(applicationContext, MyService::class.java)
                    startService(intent)
                    Log.d("흠1", "checkPermission: ")
                } else {
                    Toast.makeText(this, "권환에 동의하지 않아 앱이 종료됩니다.", Toast.LENGTH_LONG).show()
                    finish()
                }
            }
        }
    }
}