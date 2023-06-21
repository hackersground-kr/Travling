package com.traveling.presentation.features.main.alarm

import androidx.fragment.app.viewModels
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentAlarmBinding
import com.traveling.presentation.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlarmFragment : BaseFragment<FragmentAlarmBinding, AlarmViewModel>() {
    override val viewModel: AlarmViewModel by viewModels()
    override fun observerViewModel() {

    }
}