package com.traveling.presentation.features.lock.heal

import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.traveling.presentation.R
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentHealBinding
import com.traveling.presentation.features.lock.heal.HealViewModel.Companion.ON_CLICK_BACK
import com.traveling.presentation.features.lock.screen.ScreenViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HealFragment: BaseFragment<FragmentHealBinding, HealViewModel>() {
    override val viewModel: HealViewModel by viewModels()

    override fun observerViewModel() {
        bindingViewEvent { event ->
            when (event) {
                ON_CLICK_BACK -> findNavController().popBackStack()
            }
        }
    }
}