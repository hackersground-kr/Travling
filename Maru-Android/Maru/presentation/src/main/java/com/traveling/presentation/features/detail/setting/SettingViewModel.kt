package com.traveling.presentation.features.detail.setting

import com.traveling.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(

): BaseViewModel() {
    fun onClickNotice() {
        viewEvent(ON_CLICK_NOTICE)
    }
    
    fun onClickPrivate() {
        viewEvent(ON_CLICK_PRIVATE)
    }

    fun onClickUse() {
        viewEvent(ON_CLICK_USE)
    }

    companion object {
        const val ON_CLICK_NOTICE = 0
        const val ON_CLICK_PRIVATE = 1
        const val ON_CLICK_USE = 2
    }
}