package com.traveling.presentation.features.main.walk

import androidx.fragment.app.viewModels
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentHomeBinding
import com.traveling.presentation.databinding.FragmentWalkBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WalkFragment : BaseFragment<FragmentWalkBinding, WalkViewModel>() {
    override val viewModel: WalkViewModel by viewModels()
    override fun observerViewModel() {

    }
}