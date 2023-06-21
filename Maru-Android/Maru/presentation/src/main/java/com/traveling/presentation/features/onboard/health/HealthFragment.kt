package com.traveling.presentation.features.onboard.health

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.traveling.presentation.R
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentHealthBinding
import com.traveling.presentation.features.onboard.OnBoardActivity
import com.traveling.presentation.features.onboard.health.HealthViewModel.Companion.ON_CLICK_MD
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HealthFragment : BaseFragment<FragmentHealthBinding, HealthViewModel>() {
    override val viewModel: HealthViewModel by viewModels()
    override fun observerViewModel() {
        bindingViewEvent {  event ->
            when (event) {
                ON_CLICK_MD -> findNavController().navigate(R.id.action_healthFragment_to_mdFragment)
            }
        }
    }
}