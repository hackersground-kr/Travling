package com.traveling.presentation.features.lock

import android.app.KeyguardManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import com.traveling.presentation.base.BaseActivity
import com.traveling.presentation.databinding.ActivityLockBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LockActivity: BaseActivity<ActivityLockBinding, LockViewModel>() {
    override val viewModel: LockViewModel by viewModels()

    override fun observerViewModel() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            setShowWhenLocked(true)
            //setTurnScreenOn(true)
            val keyguardManager = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
            keyguardManager.requestDismissKeyguard(this, null)
        } else {
            this.window.addFlags(
                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD or
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                        WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON)
        }
    }

}