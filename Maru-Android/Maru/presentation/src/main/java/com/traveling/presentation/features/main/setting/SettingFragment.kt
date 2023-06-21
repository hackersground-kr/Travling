package com.traveling.presentation.features.main.setting

import androidx.activity.viewModels
import com.traveling.presentation.base.BaseActivity
import com.traveling.presentation.databinding.FragmentSettingBinding
import com.traveling.presentation.features.main.setting.SettingViewModel.Companion.ON_CLICK_PR

class SettingFragment: BaseActivity<FragmentSettingBinding, SettingViewModel>() {
    override val viewModel: SettingViewModel by viewModels()

    override fun observerViewModel() {
        bindingViewEvent {
            when (it) {
                ON_CLICK_PR -> {

                }
            }
        }
    }
}