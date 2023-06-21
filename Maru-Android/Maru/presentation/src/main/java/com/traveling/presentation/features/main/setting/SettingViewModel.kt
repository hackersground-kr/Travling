package com.traveling.presentation.features.main.setting

import com.traveling.presentation.base.BaseViewModel
import javax.inject.Inject

class SettingViewModel @Inject constructor(

): BaseViewModel() {
    fun onClickPr() {
        viewEvent(ON_CLICK_PR)
    }
    companion object {
        const val ON_CLICK_PR = 0
    }
}