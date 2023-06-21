package com.traveling.presentation.features.main.walk

import androidx.fragment.app.viewModels
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentHealthBinding
import com.traveling.presentation.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val viewModel: HomeViewModel by viewModels()
    override fun observerViewModel() {

    }
}