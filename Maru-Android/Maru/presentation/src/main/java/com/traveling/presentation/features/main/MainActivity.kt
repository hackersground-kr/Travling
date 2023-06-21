package com.traveling.presentation.features.main

import androidx.activity.viewModels
import com.traveling.presentation.base.BaseActivity
import com.traveling.presentation.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val viewModel: MainViewModel by viewModels()
    override fun observerViewModel() {
    }
}