package com.traveling.presentation.features.main

import android.content.Intent
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import com.traveling.presentation.R
import com.traveling.presentation.base.BaseActivity
import com.traveling.presentation.databinding.ActivityMainBinding
import com.traveling.presentation.features.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val viewModel: MainViewModel by viewModels()
    override fun observerViewModel() {}

    override fun onStart() {
        super.onStart()
        initToolBar()
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
}