package com.traveling.presentation.features.main.setting

import androidx.activity.viewModels
import com.traveling.presentation.base.BaseActivity
import com.traveling.presentation.databinding.FragmentSettingBinding

class SettingFragment: BaseActivity<FragmentSettingBinding, SettingViewModel>() {
    override val viewModel: SettingViewModel by viewModels()

    override fun observerViewModel() {
    }
}