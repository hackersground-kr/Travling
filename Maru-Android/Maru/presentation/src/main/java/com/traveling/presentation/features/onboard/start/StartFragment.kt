package com.traveling.presentation.features.onboard.start

import androidx.fragment.app.viewModels
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentHealthBinding
import com.traveling.presentation.databinding.FragmentStartBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartFragment : BaseFragment<FragmentStartBinding, StartViewModel>() {
    override val viewModel: StartViewModel by viewModels()
    override fun observerViewModel() {

    }
}