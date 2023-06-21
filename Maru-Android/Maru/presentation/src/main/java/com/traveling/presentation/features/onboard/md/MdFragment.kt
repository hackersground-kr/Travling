package com.traveling.presentation.features.onboard.md

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
        initAlarm()
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

    private fun initAlarm() {
        with(MaruApplication) {
            mBinding.mdMorningHour.setText(prefs.day11)
            mBinding.mdMorningMin.setText(prefs.day12)
            mBinding.mdLunchHour.setText(prefs.day21)
            mBinding.mdLunchMin.setText(prefs.day22)
            mBinding.mdDinnerHour.setText(prefs.day31)
            mBinding.mdDinnerMin.setText(prefs.day32)
        }
    }
}