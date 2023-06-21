package com.traveling.presentation.features.onboard

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.traveling.presentation.base.BaseActivity
import com.traveling.presentation.databinding.ActivityOnBoardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardActivity : BaseActivity<ActivityOnBoardBinding, OnBoardViewModel>() {
    override val viewModel: OnBoardViewModel by viewModels()
    override fun observerViewModel() {

    }

}