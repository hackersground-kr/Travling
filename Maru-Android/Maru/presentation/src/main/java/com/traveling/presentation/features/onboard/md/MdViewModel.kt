package com.traveling.presentation.features.onboard.md

import com.traveling.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MdViewModel @Inject constructor(

): BaseViewModel() {

    fun onClickComplete() {
        viewEvent(ON_CLICK_COMPLETE)
    }

    companion object {
        const val ON_CLICK_COMPLETE = 0
    }
}