package com.traveling.presentation.features.main.home

import android.util.Log
import com.traveling.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

): BaseViewModel() {

    fun onClickFood() {
        Log.d("로그", "HomeViewModel - onClickFood() called")
        viewEvent(ON_CLICK_FOOD)
    }

    companion object {
        const val ON_CLICK_FOOD = 0
    }
}