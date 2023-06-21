package com.traveling.presentation.features.onboard.health

import androidx.fragment.app.viewModels
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentHealthBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HealthFragment : BaseFragment<FragmentHealthBinding, HealthViewModel>() {
    override val viewModel: HealthViewModel by viewModels()
    override fun observerViewModel() {

    }
}