package com.traveling.presentation.features.onboard.start

import com.traveling.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(

): BaseViewModel() {
    fun onClickStart() {
        viewEvent(ON_CLICK_START)
    }

    companion object {
        const val ON_CLICK_START = 0
    }
}