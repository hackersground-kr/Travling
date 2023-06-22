package com.traveling.presentation.features.lock.heal

import androidx.fragment.app.viewModels
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentHealBinding

class HealFragment: BaseFragment<FragmentHealBinding, HealViewModel>() {
    override val viewModel: HealViewModel by viewModels()

    override fun observerViewModel() {
    }
}