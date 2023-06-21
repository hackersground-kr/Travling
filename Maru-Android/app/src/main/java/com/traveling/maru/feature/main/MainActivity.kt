package com.traveling.maru.feature.main

import androidx.activity.viewModels
import com.traveling.maru.base.BaseActivity
import com.traveling.maru.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val viewModel: MainViewModel by viewModels()
    override fun observerViewModel() {

    }
}