package com.traveling.presentation.features.main

import androidx.activity.viewModels
import com.traveling.presentation.R
import com.traveling.presentation.base.BaseActivity
import com.traveling.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val viewModel: MainViewModel by viewModels()
    override fun observerViewModel() {
    }

    override fun onStart() {
        super.onStart()
        initToolBar()
    }
    private fun initToolBar() {
        setSupportActionBar(mBinding.toolBar)
        with(supportActionBar!!) {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
            setDisplayShowTitleEnabled(false)
        }
    }
}