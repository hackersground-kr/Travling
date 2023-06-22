package com.traveling.presentation.features.detail.setting

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.viewModels
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentSettingBinding
import com.traveling.presentation.features.detail.setting.SettingViewModel.Companion.ON_BACK
import com.traveling.presentation.features.detail.setting.SettingViewModel.Companion.ON_CLICK_NOTICE
import com.traveling.presentation.features.detail.setting.SettingViewModel.Companion.ON_CLICK_PRIVATE
import com.traveling.presentation.features.detail.setting.SettingViewModel.Companion.ON_CLICK_USE
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SettingFragment: BaseFragment<FragmentSettingBinding, SettingViewModel>() {
    override val viewModel: SettingViewModel by viewModels()

    override fun observerViewModel() {
        bindingViewEvent {
            when (it) {
                ON_CLICK_NOTICE -> {
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://tartan-calliandra-359.notion.site/f2de093778c445d5980a82b5743b080c?pvs=4"))
                    startActivity(browserIntent)
                }
                ON_CLICK_PRIVATE -> {
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/search?q=dd"))
                    startActivity(browserIntent)
                }
                ON_CLICK_USE -> {
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/search?q=그런건없어용"))
                    startActivity(browserIntent)
                }
                ON_BACK -> activity?.finish()
            }
        }
    }
}