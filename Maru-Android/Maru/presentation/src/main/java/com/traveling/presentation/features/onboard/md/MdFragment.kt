package com.traveling.presentation.features.onboard.md

import androidx.fragment.app.viewModels
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentHealthBinding
import com.traveling.presentation.databinding.FragmentMdBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MdFragment : BaseFragment<FragmentMdBinding, MdViewModel>() {
    override val viewModel: MdViewModel by viewModels()
    override fun observerViewModel() {

    }
}