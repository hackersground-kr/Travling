package com.traveling.presentation.features.onboard.start

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.traveling.presentation.R
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentHealthBinding
import com.traveling.presentation.databinding.FragmentStartBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartFragment : BaseFragment<FragmentStartBinding, StartViewModel>() {
    override val viewModel: StartViewModel by viewModels()
    override fun observerViewModel() {
        bindingViewEvent { event ->
            when (event) {
                StartViewModel.ON_CLICK_START -> findNavController().navigate(R.id.action_startFragment_to_healthFragment)
            }
        }
    }
}