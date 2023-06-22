package com.traveling.presentation.features.onboard.md

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.traveling.presentation.base.BaseFragment
import com.traveling.presentation.databinding.FragmentHealthBinding
import com.traveling.presentation.databinding.FragmentMdBinding
import com.traveling.presentation.features.main.MainActivity
import com.traveling.presentation.features.onboard.OnBoardActivity
import com.traveling.presentation.features.onboard.md.MdViewModel.Companion.ON_CLICK_COMPLETE
import com.traveling.presentation.features.onboard.md.MdViewModel.Companion.RETRY
import com.traveling.presentation.wiget.MaruApplication
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MdFragment : BaseFragment<FragmentMdBinding, MdViewModel>() {
    override val viewModel: MdViewModel by viewModels()
    override fun observerViewModel() {
        bindingViewEvent { event ->
             when (event) {
                 ON_CLICK_COMPLETE -> {
                     if (activity is OnBoardActivity) {
                         (activity as OnBoardActivity).startMainActivity()
                     } else if (activity is MainActivity) {
                         findNavController().popBackStack()
                     }
                 }
                 RETRY -> Toast.makeText(activity, "시간을 다시 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        initAlarm()
    }

    private fun initAlarm() {
        Log.d("로그", "${MaruApplication.prefs.day11} - initAlarm() called")
        with(MaruApplication) {
            viewModel.day11.value = prefs.day11
            viewModel.day12.value = prefs.day12
            viewModel.day21.value = prefs.day21
            viewModel.day22.value = prefs.day22
            viewModel.day31.value = prefs.day31
            viewModel.day32.value = prefs.day32

        }
    }
}