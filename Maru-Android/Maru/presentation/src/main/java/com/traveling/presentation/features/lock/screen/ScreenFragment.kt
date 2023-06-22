package com.traveling.presentation.features.lock.screen

import android.os.Build.VERSION_CODES.O
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.traveling.presentation.R
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentScreenBinding
import com.traveling.presentation.features.lock.screen.ScreenViewModel.Companion.ON_CLICK_EXIT
import com.traveling.presentation.features.lock.screen.ScreenViewModel.Companion.ON_CLICK_HEAL
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Calendar

@AndroidEntryPoint
class ScreenFragment: BaseFragment<FragmentScreenBinding, ScreenViewModel>() {
    override val viewModel: ScreenViewModel by viewModels()
    private var job: Job? = null
    override fun observerViewModel() {
        bindingViewEvent { event ->
            when (event) {
                ON_CLICK_HEAL -> findNavController().navigate(R.id.action_screenFragment_to_healFragment)
                ON_CLICK_EXIT -> activity?.finish()
            }
        }
        job = viewModel.viewModelScope.launch(Dispatchers.IO) {
            while (isFragmentActive()) {

                viewModel.time.postValue(viewModel.getCurrentTime())
                viewModel.date.postValue(viewModel.getCurrentDate())
//                mBinding.lockTime.text = viewModel.getCurrentTime()
//                mBinding.lockDate.text = viewModel.getCurrentDate()
//                mBinding.lockDate.text = viewModel.getCurrentDate()
                delay(1000)
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        job?.cancel()
    }
    private fun isFragmentActive(): Boolean {
        return isAdded && !isDetached && !isRemoving
    }


}