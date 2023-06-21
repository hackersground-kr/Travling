package com.traveling.presentation.features.onboard.md

import androidx.fragment.app.viewModels
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentHealthBinding
import com.traveling.presentation.databinding.FragmentMdBinding
import com.traveling.presentation.features.onboard.OnBoardActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MdFragment : BaseFragment<FragmentMdBinding, MdViewModel>() {
    override val viewModel: MdViewModel by viewModels()
    override fun observerViewModel() {
        bindingViewEvent { event ->
             when (event) {
                MdViewModel.ON_CLICK_COMPLETE -> (activity as OnBoardActivity).startMainActivity()
            }
        }
    }
}