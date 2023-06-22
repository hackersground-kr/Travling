package com.traveling.presentation.features.lock.screen

import androidx.fragment.app.viewModels
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentScreenBinding

class ScreenFragment: BaseFragment<FragmentScreenBinding, ScreenViewModel>() {
    override val viewModel: ScreenViewModel by viewModels()

    override fun observerViewModel() {
    }
}