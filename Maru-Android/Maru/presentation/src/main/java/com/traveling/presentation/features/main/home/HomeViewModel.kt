package com.traveling.presentation.features.main.home

import androidx.lifecycle.MutableLiveData
import com.traveling.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

): BaseViewModel() {
    val setting = MutableLiveData<Boolean>()

    fun onClickFood() {
        viewEvent(ON_CLICK_FOOD)
    }

    fun onClickProfile() {
        viewEvent(ON_CLICK_PROFILE)
    }

    fun onClickWalk() {
        viewEvent(ON_CLICK_WALK)
    }

    fun onClickAlarm() {
        viewEvent(ON_CLICK_ALARM)
    }

    companion object {
        const val ON_CLICK_FOOD = 0
        const val ON_CLICK_PROFILE = 1
        const val ON_CLICK_WALK = 2
        const val ON_CLICK_ALARM = 3
    }
}
