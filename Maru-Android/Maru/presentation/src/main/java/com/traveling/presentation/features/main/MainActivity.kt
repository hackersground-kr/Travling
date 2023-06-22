package com.traveling.presentation.features.main

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import com.traveling.presentation.R
import com.traveling.presentation.base.BaseActivity
import com.traveling.presentation.databinding.ActivityMainBinding
import com.traveling.presentation.features.detail.DetailActivity
import com.traveling.presentation.wiget.MyService
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val viewModel: MainViewModel by viewModels()
    private var OVERLAY_PERMISSION_REQUEST_CODE = 100
    override fun observerViewModel() {}

    override fun onStart() {
        super.onStart()
        initToolBar()
        checkPermission()
    }

    private fun initToolBar() {
        setSupportActionBar(mBinding.toolBar)
        mBinding.drawer.isClickable = false
        with(supportActionBar!!) {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
            setDisplayShowTitleEnabled(false)
        }

        val navigationView = mBinding.navView
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    findNavController(R.id.nav_host_main).popBackStack(R.id.homeFragment, false)
                    mBinding.drawer.closeDrawers()
                }
                R.id.setting -> {
                    val intent = Intent(applicationContext, DetailActivity::class.java)
                    startActivity(intent)
                    mBinding.drawer.closeDrawers()
                }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                mBinding.drawer.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
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