package com.traveling.presentation.features.main.home

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.traveling.presentation.R
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentHomeBinding
import com.traveling.presentation.features.main.home.HomeViewModel.Companion.ON_CLICK_ALARM
import com.traveling.presentation.features.main.home.HomeViewModel.Companion.ON_CLICK_FOOD
import com.traveling.presentation.features.main.home.HomeViewModel.Companion.ON_CLICK_PROFILE
import com.traveling.presentation.features.main.home.HomeViewModel.Companion.ON_CLICK_WALK
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val viewModel: HomeViewModel by viewModels()
    override fun observerViewModel() {
        bindingViewEvent { event ->
            when (event) {
                ON_CLICK_FOOD -> findNavController().navigate(R.id.action_homeFragment_to_foodFragment)
                ON_CLICK_PROFILE -> findNavController().navigate(R.id.action_homeFragment_to_healthFragment)
                ON_CLICK_WALK -> findNavController().navigate(R.id.action_homeFragment_to_walkFragment)
                ON_CLICK_ALARM -> findNavController().navigate(R.id.action_homeFragment_to_mdFragment)
            }
        }
    }
}
