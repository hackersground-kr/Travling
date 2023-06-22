package com.traveling.presentation.features.lock

import androidx.activity.viewModels
import com.traveling.presentation.base.BaseActivity
import com.traveling.presentation.databinding.ActivityLockBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LockActivity: BaseActivity<ActivityLockBinding, LockViewModel>() {
    override val viewModel: LockViewModel by viewModels()

    override fun observerViewModel() {

    }

}