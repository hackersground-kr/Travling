package com.traveling.presentation.features.detail.setting

import android.util.Log
import androidx.fragment.app.viewModels
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentSettingBinding
import com.traveling.presentation.features.detail.setting.SettingViewModel.Companion.ON_CLICK_NOTICE
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment: BaseFragment<FragmentSettingBinding, SettingViewModel>() {
    override val viewModel: SettingViewModel by viewModels()

    override fun observerViewModel() {
        bindingViewEvent {
            when (it) {
                ON_CLICK_NOTICE -> {
                    Log.d("로그", "SettingFragment - observerViewModel() called")
                }
            }
        }
    }
}