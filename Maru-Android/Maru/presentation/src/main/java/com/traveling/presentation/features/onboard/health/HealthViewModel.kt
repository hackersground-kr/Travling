package com.traveling.presentation.features.onboard.health

import com.traveling.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HealthViewModel @Inject constructor(

): BaseViewModel() {

    fun onClickMd() {
        viewEvent(ON_CLICK_MD)
    }

    companion object {
        const val ON_CLICK_MD = 0
    }
}